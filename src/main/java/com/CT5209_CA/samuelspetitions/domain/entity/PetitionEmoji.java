package com.CT5209_CA.samuelspetitions.domain.entity;

import lombok.Getter;

@Getter
public enum PetitionEmoji {
    ANGRY("😠"),
    SURPRISED("😲"),
    HAPPY("😃"),
    SAD("😢"),
    THINKING("🤔");

    private final String emoji;
    PetitionEmoji(String emoji) {
        this.emoji = emoji;
    }

    public static boolean isValidEmoji(String value) {
        for (PetitionEmoji emoji : PetitionEmoji.values()) {
            return emoji.getEmoji().equals(value);
        }
        return false;
    }
}
