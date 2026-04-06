package com.shatteredpixel.shatteredpixeldungeon.items.albums;

import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.utils.DeviceCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public abstract class Album extends Item {

    public HashMap<String, String> songs = new HashMap<>();

    {
        stackable = false;
        unique = true;
    }

    @Override
    public String desc() {
        //This thing is so messy.
        StringBuilder desc = new StringBuilder(super.desc() + Messages.get(Album.class, "contains"));

        for (Map.Entry<String, String> song : songs.entrySet()) {
            desc.append("\n");
            desc.append(song.getKey());
            try {
                desc.append(" | ").append(songDuration(song.getValue()));
            } catch (Exception e) {
                if (DeviceCompat.isDebug())
                    GLog.w(e.toString());
            }
        }
        return desc.toString();
    }

    //This was written by chatGPT and it seems to just work...
    public static String songDuration(String songpath) throws IOException {
        String filepath = System.getProperty("user.dir") + "\\build\\resources\\main\\" + songpath;

        try (FileInputStream stream = new FileInputStream(filepath)) {
            File file = new File(filepath);
            byte[] buffer = new byte[(int) file.length()];
            stream.read(buffer);

            long granulePosition = -1;
            int sampleRate = -1;

            // Search for the sample rate (from the Vorbis identification header)
            for (int i = 0; i < buffer.length - 6; i++) {
                if (buffer[i] == 'v' && buffer[i + 1] == 'o' && buffer[i + 2] == 'r' && buffer[i + 3] == 'b' && buffer[i + 4] == 'i' && buffer[i + 5] == 's') {
                    // Sample rate is 4 bytes at offset 11
                    ByteBuffer sampleRateBuffer = ByteBuffer.wrap(buffer, i + 11, 4);
                    sampleRateBuffer.order(ByteOrder.LITTLE_ENDIAN);
                    sampleRate = sampleRateBuffer.getInt();
                    break;
                }
            }

            if (sampleRate <= 0) {
                throw new IOException("Failed to find valid sample rate in the file.");
            }

            // Search for the granule position (from the last OggS header)
            for (int i = buffer.length - 27; i >= 0; i--) {
                if (buffer[i] == 'O' && buffer[i + 1] == 'g' && buffer[i + 2] == 'g' && buffer[i + 3] == 'S') {
                    // Granule position is 8 bytes at offset 6
                    ByteBuffer granuleBuffer = ByteBuffer.wrap(buffer, i + 6, 8);
                    granuleBuffer.order(ByteOrder.LITTLE_ENDIAN);
                    granulePosition = granuleBuffer.getLong();
                    break;
                }
            }

            if (granulePosition < 0) {
                throw new IOException("Failed to find valid granule position in the file.");
            }

            // Calculate duration in seconds
            int duration = (int) (granulePosition / sampleRate);
            int min = duration / 60;
            int sec = duration % 60;
            return String.format(Locale.getDefault(), "%d:%02d", min, sec);
        }
    }

    @Override
    public boolean isUpgradable() {
        return false;
    }

    @Override
    public boolean isIdentified() {
        return true;
    }
}
