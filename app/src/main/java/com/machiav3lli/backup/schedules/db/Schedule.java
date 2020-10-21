/*
 * OAndBackupX: open-source apps backup and restore app.
 * Copyright (C) 2020  Antonios Hazim
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.machiav3lli.backup.schedules.db;

import android.content.SharedPreferences;
import android.util.ArraySet;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.machiav3lli.backup.Constants;
import com.machiav3lli.backup.schedules.SchedulingException;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Holds scheduling data
 */
@Entity
public class Schedule {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private boolean enabled = false;
    private int hour = 0;
    private int interval = 1;
    private long placed = System.currentTimeMillis();
    @TypeConverters(ModeConverter.class)
    private Mode mode;
    @TypeConverters(SubmodeConverter.class)
    private Submode submode;
    private long timeUntilNextEvent;
    private boolean excludeSystem = false;
    private boolean enableCustomList = false;
    @TypeConverters(CustomListConverter.class)
    private Set<String> customList = new ArraySet<>();

    public Schedule() {
        mode = Mode.ALL;
        submode = Submode.BOTH;
    }

    /**
     * Get scheduling data from a preferences file.
     *
     * @param preferences preferences object
     * @param number      index of schedule to fetch
     * @return scheduling data object
     */
    public static Schedule fromPreferences(SharedPreferences preferences, long number) throws SchedulingException {
        final Schedule schedule = new Schedule();
        schedule.id = number;
        schedule.enabled = preferences.getBoolean(Constants.PREFS_SCHEDULES_ENABLED + number, false);
        schedule.hour = preferences.getInt(Constants.PREFS_SCHEDULES_HOUROFDAY + number, 0);
        schedule.interval = preferences.getInt(Constants.PREFS_SCHEDULES_INTERVAL + number, 1);
        schedule.placed = preferences.getLong(Constants.PREFS_SCHEDULES_TIMEPLACED + number, 0);
        schedule.mode = Mode.intToMode(preferences.getInt(Constants.PREFS_SCHEDULES_MODE + number, 0));
        schedule.submode = Submode.intToSubmode(preferences.getInt(Constants.PREFS_SCHEDULES_SUBMODE + number, 0));
        schedule.excludeSystem = preferences.getBoolean(Constants.PREFS_SCHEDULES_EXCLUDESYSTEM + number, false);
        schedule.customList = preferences.getStringSet(Constants.PREFS_SCHEDULES_CUSTOMLIST + number, new ArraySet<>());
        return schedule;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getInterval() {
        return this.interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public long getPlaced() {
        return this.placed;
    }

    public void setPlaced(long placed) {
        this.placed = placed;
    }

    public Mode getMode() {
        return this.mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public Submode getSubmode() {
        return this.submode;
    }

    public void setSubmode(Submode submode) {
        this.submode = submode;
    }

    public long getTimeUntilNextEvent() {
        return this.timeUntilNextEvent;
    }

    public void setTimeUntilNextEvent(long timeUntilNextEvent) {
        this.timeUntilNextEvent = timeUntilNextEvent;
    }

    public boolean isExcludeSystem() {
        return this.excludeSystem;
    }

    public void setExcludeSystem(boolean excludeSystem) {
        this.excludeSystem = excludeSystem;
    }


    public boolean isEnableCustomList() {
        return this.enableCustomList;
    }

    public void setEnableCustomList(boolean enableCustomList) {
        this.enableCustomList = enableCustomList;
    }

    public Set<String> getCustomList() {
        return this.customList;
    }

    public void setCustomList(Set<String> customList) {
        this.customList = customList;
    }

    /**
     * Persist the scheduling data.
     *
     * @param preferences shared preferences object
     */
    public void persist(SharedPreferences preferences) {
        preferences.edit()
                .putBoolean(Constants.PREFS_SCHEDULES_ENABLED + id, enabled)
                .putInt(Constants.PREFS_SCHEDULES_HOUROFDAY + id, hour)
                .putInt(Constants.PREFS_SCHEDULES_INTERVAL + id, interval)
                .putLong(Constants.PREFS_SCHEDULES_TIMEPLACED + id, placed)
                .putInt(Constants.PREFS_SCHEDULES_MODE + id, mode.value)
                .putInt(Constants.PREFS_SCHEDULES_SUBMODE + id, submode.value)
                .putBoolean(Constants.PREFS_SCHEDULES_EXCLUDESYSTEM + id, excludeSystem)
                .putBoolean(Constants.PREFS_SCHEDULES_ENABLECUSTOMLIST + id, enableCustomList)
                .putStringSet(Constants.PREFS_SCHEDULES_CUSTOMLIST, customList)
                .apply();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return id == schedule.id &&
                enabled == schedule.enabled &&
                hour == schedule.hour &&
                interval == schedule.interval &&
                placed == schedule.placed &&
                excludeSystem == schedule.excludeSystem &&
                enableCustomList == schedule.enableCustomList &&
                mode == schedule.mode &&
                submode == schedule.submode &&
                customList.equals(schedule.customList);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) id;
        hash = 31 * hash + (enabled ? 1 : 0);
        hash = 31 * hash + hour;
        hash = 31 * hash + interval;
        hash = 31 * hash + (int) placed;
        hash = 31 * hash + mode.hashCode();
        hash = 31 * hash + submode.hashCode();
        hash = 31 * hash + (excludeSystem ? 1 : 0);
        hash = 31 * hash + (enableCustomList ? 1 : 0);
        hash = 31 * hash + customList.hashCode();
        return hash;
    }

    @NotNull
    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", enabled=" + enabled +
                ", hour=" + hour +
                ", interval=" + interval +
                ", placed=" + placed +
                ", mode=" + mode +
                ", submode=" + submode +
                ", excludeSystem=" + excludeSystem +
                ", enableCustomList=" + enableCustomList +
                ", customList=" + customList +
                '}';
    }

    public static class Builder {
        final Schedule schedule;

        public Builder() {
            schedule = new Schedule();
        }

        public Builder withId(int id) {
            schedule.id = id;
            return this;
        }

        public Builder withEnabled(boolean enabled) {
            schedule.enabled = enabled;
            return this;
        }

        public Builder withHour(int hour) {
            schedule.hour = hour;
            return this;
        }

        public Builder withInterval(int interval) {
            schedule.interval = interval;
            return this;
        }

        public Builder withPlaced(long placed) {
            schedule.placed = placed;
            return this;
        }

        public Builder withMode(Schedule.Mode mode) {
            schedule.mode = mode;
            return this;
        }

        public Builder withSubmode(Schedule.Submode submode) {
            schedule.submode = submode;
            return this;
        }

        public Builder withExcludeSystem(boolean excludeSystem) {
            schedule.excludeSystem = excludeSystem;
            return this;
        }

        public Builder withEnableCustomList(boolean enableCustomList) {
            schedule.enableCustomList = enableCustomList;
            return this;
        }

        public Builder withCustomList(Set<String> customlist) {
            schedule.customList = customlist;
            return this;
        }

        public Schedule build() {
            return schedule;
        }
    }

    /**
     * Scheduling mode, which packages to include in the scheduled backup
     */
    public enum Mode {
        ALL(0),
        USER(1),
        SYSTEM(2),
        NEW_UPDATED(3),
        CUSTOM(4);

        private final int value;

        Mode(int value) {
            this.value = value;
        }

        /**
         * Convert from int to mode. This method exists to handle the
         * transition from storing having mode stored as integers to
         * representing it as an enum.
         *
         * @param mode number written to disk
         * @return corresponding mode
         */
        public static Mode intToMode(int mode) throws SchedulingException {
            switch (mode) {
                case 0:
                    return ALL;
                case 1:
                    return USER;
                case 2:
                    return SYSTEM;
                case 3:
                    return NEW_UPDATED;
                case 4:
                    return CUSTOM;
                default:
                    throw new SchedulingException(String.format(
                            "Unknown mode %s", mode));
            }
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * Scheduling submode, whether to include apk, data or both in the backup
     */
    public enum Submode {
        APK(0),
        DATA(1),
        BOTH(2);
        private final int value;

        Submode(int value) {
            this.value = value;
        }

        /**
         * Convert from int to submode. This method exists to handle the
         * transition from storing having submode stored as integers to
         * representing it as an enum.
         *
         * @param submode number written to disk
         * @return corresponding submode
         */
        public static Submode intToSubmode(int submode) throws SchedulingException {
            switch (submode) {
                case 0:
                    return APK;
                case 1:
                    return DATA;
                case 2:
                    return BOTH;
                default:
                    throw new SchedulingException(String.format(
                            "Unknown submode %s", submode));
            }
        }

        public int getValue() {
            return value;
        }
    }

    static class ModeConverter {
        private ModeConverter() {
        }

        @TypeConverter
        public static String toString(Mode mode) {
            return mode.name();
        }

        @TypeConverter
        public static Mode toMode(String name) {
            return Mode.valueOf(name);
        }
    }

    static class SubmodeConverter {
        private SubmodeConverter() {
        }

        @TypeConverter
        public static String toString(Submode submode) {
            return submode.name();
        }

        @TypeConverter
        public static Submode toSubmode(String name) {
            return Submode.valueOf(name);
        }
    }

    static class CustomListConverter {
        private CustomListConverter() {
        }

        @TypeConverter
        public static Set<String> toCustomList(String stringCustomList) {
            return new HashSet<>(Arrays.asList(stringCustomList.split(",")));
        }

        @TypeConverter
        public static String toString(Set<String> customList) {
            return String.join(",", customList);
        }
    }
}
