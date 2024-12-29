/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2022 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon.scenes;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Chrome;
import com.shatteredpixel.shatteredpixeldungeon.ShatteredPixelDungeon;
import com.shatteredpixel.shatteredpixeldungeon.Skin;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSprite;
import com.shatteredpixel.shatteredpixeldungeon.ui.Archs;
import com.shatteredpixel.shatteredpixeldungeon.ui.ExitButton;
import com.shatteredpixel.shatteredpixeldungeon.ui.Icons;
import com.shatteredpixel.shatteredpixeldungeon.ui.RenderedTextBlock;
import com.shatteredpixel.shatteredpixeldungeon.ui.ScrollPane;
import com.shatteredpixel.shatteredpixeldungeon.ui.StyledButton;
import com.shatteredpixel.shatteredpixeldungeon.ui.Window;
import com.watabou.noosa.Camera;
import com.watabou.noosa.Image;
import com.watabou.noosa.NinePatch;
import com.watabou.noosa.ui.Component;
import com.watabou.utils.DeviceCompat;
import com.watabou.utils.Random;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class StoreScene extends PixelScene {

	private static final int BTN_HEIGHT = 22;
	private static final int GAP = 2;

	public boolean mobile = DeviceCompat.isAndroid();

	public static List<Skin> skinsOnSale = new ArrayList<>();

	@Override
	public void create() {
		super.create();

		skinsOnSale.clear();

		uiCamera.visible = false;

		int w = Camera.main.width;
		int h = Camera.main.height;

		int elementWidth = PixelScene.landscape() ? 202 : 120;


		Archs archs = new Archs();
		archs.setSize(w, h);
		add(archs);




		ScrollPane list = new ScrollPane( new Component() );
		add( list );



		Component content = list.content();
		content.clear();

		ExitButton btnExit = new ExitButton();
		btnExit.setPos(w - btnExit.width(), 0);
		content.add(btnExit);

		RenderedTextBlock title = PixelScene.renderTextBlock(Messages.get(this, "title"), 10);
		title.hardlight(Window.TITLE_COLOR);
		title.setPos(
				(w - title.width()) / 2f,
				(20 - title.height()) / 2f
		);
		align(title);
		content.add(title);

		RenderedTextBlock titleDesc = PixelScene.renderTextBlock(Messages.get(this, "titledesc", timeLeft()), 8);
		titleDesc.setPos(title.left() - (titleDesc.width() - title.width()) / 2, title.bottom() + 5);
		align(titleDesc);
		content.add(titleDesc);


		BattlePassBox battlepass = new BattlePassBox();
		battlepass.setSize(elementWidth, 0);
		content.add(battlepass);

		float elementHeight = battlepass.height() + BTN_HEIGHT + GAP;

		float top = elementHeight / 2;
		float left = (w-elementWidth)/2f;

		battlepass.setPos(left, top);
		align(battlepass);

		RenderedTextBlock itemStoreTitle = PixelScene.renderTextBlock(Messages.get(this, "itemstoretitle"), 10);
		itemStoreTitle.setPos(battlepass.left() + battlepass.width() / 2 - itemStoreTitle.width() / 2, battlepass.bottom() + 15);
		itemStoreTitle.hardlight(Window.LEGENDARY_COLOR);
		align(itemStoreTitle);
		content.add(itemStoreTitle);

		float storeBottom = itemStoreTitle.bottom();
		for (int i = 1; i <= 12; i++) {
			ShopItem shopItem = new ShopItem(Icons.get(Icons.SHIT),Messages.get(this, "item") + i, i);
			if (mobile) {
				shopItem.setPos(battlepass.left() + 15, itemStoreTitle.bottom() - 10);
			} else {
				shopItem.setPos(battlepass.left(), itemStoreTitle.bottom() + 10);
			}
			storeBottom = shopItem.bottom();
			content.add(shopItem);
		}
		content.setSize( w, storeBottom + 10 );
		list.setRect( 0, 0, w, h );
		list.scrollTo(0, 0);
	}

	@Override
	protected void onBackPressed() {
		ShatteredPixelDungeon.switchNoFade( TitleScene.class );
	}

	private static class BattlePassBox extends Component {

		NinePatch bg;
		RenderedTextBlock title;
		RenderedTextBlock description;
		Image iconLeft;
		Image iconRight;
		RenderedTextBlock mobileDesc;
		StyledButton purchaseButton;

		@Override
		protected void createChildren() {
			bg = Chrome.get(Chrome.Type.GREY_BUTTON_TR);
			add(bg);

			String titleMessage = Messages.get(StoreScene.class, "season", fakeSeasonNumber());

			title = PixelScene.renderTextBlock(titleMessage, 12);
			add(title);

			String descMessage = Messages.get(StoreScene.class, "name_" + seasonNumber());
			description = PixelScene.renderTextBlock(descMessage, 8);
			add(description);

			iconLeft = StoreScene.seasonIcon();
			iconRight = StoreScene.seasonIcon();
			iconRight.flipHorizontal = true;
			iconRight.frame(iconRight.frame());
			add(iconLeft);
			add(iconRight);

			if (DeviceCompat.isAndroid()) {
				mobileDesc = PixelScene.renderTextBlock(Messages.get(StoreScene.class, "buypass"), 8);
				mobileDesc.hardlight(Window.TITLE_COLOR);
				add(mobileDesc);
			}

			String buttonMessage = DeviceCompat.isAndroid()
					? Messages.get(StoreScene.class, "passprice")
					: Messages.get(StoreScene.class, "buypass") + "\n" + Messages.get(StoreScene.class, "passprice");



			purchaseButton = new StyledButton(Chrome.Type.GREY_BUTTON_TR, buttonMessage){
				@Override
				protected void onClick() {
					super.onClick();
					String link = "https://www.patreon.com/ShatteredPixel";
					link += "?utm_source=shittenedpd";
					link += "&utm_medium=supporter_page";
					link += "&utm_campaign=ingame_link";
					ShatteredPixelDungeon.platform.openURI(link);
				}
			};
			purchaseButton.icon(Icons.get(Icons.GOLD));
			purchaseButton.textColor(Window.TITLE_COLOR);
			add(purchaseButton);
		}

		@Override
		protected void layout() {
			bg.x = x;
			bg.y = y;

			title.maxWidth((int)width - bg.marginHor());
			title.setPos(x + bg.marginLeft() + (bg.width / 2 - title.width() / 2), y + bg.marginTop() + 1);

			description.maxWidth((int)width - bg.marginHor());
			description.setPos(x + bg.marginLeft() + (bg.width / 2 - description.width() / 2), title.bottom() + 8);
			if (DeviceCompat.isAndroid()) {
				mobileDesc.setPos(description.left(), description.bottom() + 10);
				iconLeft.y = bg.y + 3;
				iconLeft.x = title.left() - iconLeft.width - bg.width / 10f;

				iconRight.y = bg.y + 3;
				iconRight.x = title.right() + bg.width / 10f;

				purchaseButton.setPos(bg.x + bg.width / 2 - purchaseButton.width() / 2,mobileDesc.bottom() + mobileDesc.height() / 2 + 3);

			} else {
				iconLeft.y = bg.y + title.height();
				iconLeft.x = title.left() - iconLeft.width - bg.width / 6f;

				iconRight.y = bg.y + title.height();
				iconRight.x = title.right() + bg.width / 6f;

				purchaseButton.setPos(bg.x + bg.width / 2 - purchaseButton.width() / 2,description.bottom() + description.height() / 2 + 3);

			}
			purchaseButton.setSize(bg.width / 1.5f, BTN_HEIGHT + 6);
			height = purchaseButton.bottom() + 3 - y;
			height += bg.marginBottom();


			bg.size(width, height);

		}

	}
	private static class ShopItem extends Component {

		NinePatch bg;
		RenderedTextBlock text;
		RenderedTextBlock raritytext;
		StyledButton purchaseButton;
		java.util.Random random;
		Image icon;
		String desc;
		int slot;
		boolean mobile;

		ShopItem(Image icon, String desc, int slot) {
			//TODO clean up unneccessary stuff and also finish everything
			this.icon = icon;
			this.desc = desc;
			this.slot = slot;
			this.mobile = DeviceCompat.isAndroid();
			// New random using the seasonnumber and slot as seed. To generate same items every time the shop is opened that month
			random = new java.util.Random(fakeSeasonNumber() + slot + Calendar.YEAR + Calendar.WEEK_OF_MONTH);// + Random.Int(0,50000)); //TODO REMOVE RANDOM
			createChild();
		}

		protected void createChild() {
			bg = Chrome.get(Chrome.Type.GREY_BUTTON_TR);
			add(bg);

			List<Skin> skins = Skin.all();
			if (!StoreScene.skinsOnSale.isEmpty()) {
				for (Skin skin: StoreScene.skinsOnSale) {
					skins.remove(skin);
				}
			}

			Skin skin = skins.get(random.nextInt(skins.size()));
			StoreScene.skinsOnSale.add(skin);

			icon = new ItemSprite(skin.sprite());
			text = PixelScene.renderTextBlock(skin.fullSkinName(),6);
			add(text);
			raritytext = PixelScene.renderTextBlock(skin.rarity(),5);



			add(icon);

			int price;
			switch (skin.rarityTier()) {
				case 1:
					price = 1;
					raritytext.hardlight(Window.COMMON_COLOR);
					break;
				case 2:
					price = 4;
					raritytext.hardlight(Window.RARE_COLOR);
					break;
				case 3:
					price = 9;
					raritytext.hardlight(Window.EPIC_COLOR);
					break;
				case 4:
					price = 19;
					raritytext.hardlight(Window.LEGENDARY_COLOR);
					break;
				case 5:
					price = 29;
					raritytext.hardlight(Window.MYTHIC_COLOR);
					break;
				default:
					price = 0;
					raritytext.hardlight(0x555555);
			}
			add(raritytext);

			purchaseButton = new StyledButton(Chrome.Type.GREY_BUTTON_TR, Messages.get(StoreScene.class, "buy",
					price, 99, 6)) {
				@Override
				protected void onClick() {
					super.onClick();
					String link = "https://www.patreon.com/ShatteredPixel";
					link += "?utm_source=shittenedpd";
					link += "&utm_medium=supporter_page";
					link += "&utm_campaign=ingame_link";
					ShatteredPixelDungeon.platform.openURI(link);
				}
			};
//			purchaseButton.icon(Icons.get(Icons.GOLD));
			purchaseButton.textColor(Window.TITLE_COLOR);
			add(purchaseButton);
		}

		@Override
		protected void layout() {

			float verticalOffset = 20;
			float horizontalOffset = bg.width + 100;

			if (!mobile) {
				if (slot % 2 == 0) {
					x += horizontalOffset;
				}
				if (slot % 2 == 1 ) {
					y += verticalOffset * slot;
				} else if (slot % 2 == 0) {
					y += verticalOffset * (slot - 1);
				}
			} else {
				y += verticalOffset * 1.8f * slot;
			}

			bg.x = x;
			bg.y = y;
			bg.width = width += 100;

			icon.y = bg.y + bg.height / 2;
			icon.x = bg.x + 5;

			text.maxWidth((int)(bg.width - icon.width));
			text.setPos(x + bg.marginLeft() + icon.width + 5, y + bg.marginTop() + 1);

			raritytext.maxWidth(text.maxWidth());
			raritytext.setPos(x + bg.marginLeft() + icon.width + 5, y + bg.marginTop() + text.height() + 3);

			purchaseButton.setPos(x + bg.width - 35, text.bottom() + 5);
			purchaseButton.setSize(30, 15);

			height = (text.bottom() + 20) - y;

			height += bg.marginBottom();

			bg.size(width, height);

		}
	}

	public static Image seasonIcon() {
		switch (seasonNumber()) {
			case 0:
				return new Image(Assets.Sprites.KING, 16, 0, 14, 16);
			case 1:
				Image image = new Image(Assets.Sprites.RAT, 0, 0, 16, 16);
				image.angularSpeed = Random.Int(400, 700);
				return image;
			case 2:
				return new Image(Assets.Sprites.DM100, 80, 56, 16, 14);
			case 3:
				return new Image(Assets.Sprites.SNAKE, 72, 0, 12, 11);
			case 4:
				return new Image(Assets.Sprites.ADVENTURER, 0, 0, 12, 15);
			case 5:
				return new Image(Assets.Sprites.CAPYBARA, 60, 17, 15, 17);
			case 6:
				return new Image(Assets.Sprites.GOO, 160, 0, 20, 14);
			case 7:
				return new Image(Assets.Sprites.BAT, 30, 0, 30, 13);
			case 8:
				return new Image(Assets.Environment.TILES_CAVES_CHRISTMAS, 48, 112, 32, 16);
			case 9:
				return new Image(Assets.Sprites.SKELETON, 2, 0, 9, 15);
			case 10:
				return new Image(Assets.Environment.TILES_SEWERS, 48, 48, 16, 21);
			case 11:
				return new Image(Assets.Sprites.BAT, 47, 45, 13, 13);

			case 12:
				return Icons.get(Icons.SHIT);
			case 13:
				return new Image(Assets.Sprites.PYLON, 10, 0, 10, 20);
			case 14:
				return new Image(Assets.Sprites.MIMIC, 80, 0, 16, 13);
			case 15:
				return new Image(Assets.Sprites.BEE, 64, 0, 16, 13);
			case 16:
				return new Image(Assets.Sprites.MAKER, 2, 0, 9, 14);
			case 17:
				return new Image(Assets.Sprites.SLIME, 44, 3, 10, 9);
			case 18:
				return new Image(Assets.Sprites.KING, 0, 0, 16, 16);
			case 19:
				return new Image(Assets.Sprites.KEEPER, 0, 14, 12, 15);
			case 20:
				return new Image(Assets.Sprites.TENGU, 140, 2, 15, 14);
			case 21:
				return new Image(Assets.Sprites.NECRO, 128, 0, 16, 16);
			case 22:
				return new Image(Assets.Sprites.KING, 240, 0, 16, 16);
			case 23:
				return new Image(Assets.Sprites.CAPYBARA, 60, 17, 15, 17);

			default:
				return Icons.get(Icons.SHIT);
		}
	}

	public static int seasonNumber() {
		int year = Integer.parseInt(new SimpleDateFormat("yyyy", Locale.US).format(new Date()));
		int month = Integer.parseInt(new SimpleDateFormat("M", Locale.US).format(new Date()));

//		int year = 2026;
//		int month = 1;

		int seasonYear;
		if ((year - 2023) % 2 == 1) {
			seasonYear = 0;
		} else {
			seasonYear = 12;
		}

		return month - 1 + seasonYear;
	}

	public static int fakeSeasonNumber() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM", Locale.US);
		Date startDate;
		try {
			startDate = format.parse("2023-12");
		} catch (Exception e) {
			startDate = new Date(1704110400000L);
		}

		return monthsBetween(startDate, new Date());
	}

	private static int monthsBetween(Date startDate, Date endDate) {
		//Thanks, ChatGPT.
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(startDate);

		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endDate);

		int monthsBetween = 0;

		while (startCalendar.before(endCalendar)) {
			startCalendar.add(Calendar.MONTH, 1);
			if (startCalendar.before(endCalendar)) {
				monthsBetween++;
			}
		}

		return monthsBetween;
	}

	private static String timeLeft() {
		Calendar now = Calendar.getInstance();
		Calendar nextMonth = Calendar.getInstance();
		nextMonth.add(Calendar.MONTH, 1);
		nextMonth.set(Calendar.DAY_OF_MONTH, 1);

		long difference =  nextMonth.getTimeInMillis() - now.getTimeInMillis();
		long daysLeft = difference / (1000 * 60 * 60 * 24);
		long hoursLeft = difference / (1000 * 60 * 60);
		long minutesLeft = difference / (1000 * 60);

		if (minutesLeft <= 1) {
			return "very soon!";
		}
		if (hoursLeft <= 1) {
			return "in " + minutesLeft + " minutes";
		}
		if (hoursLeft <= 24) {
			return "in " + hoursLeft + " Hours";
		}

		return "in " + daysLeft + " Days";
	}
}
