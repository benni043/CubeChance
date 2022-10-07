package at.main;

import at.endum.CubeSites;

import java.util.Arrays;

public class Main {

    private static int countGeneral = 0;
    private static int countFourOfAKind = 0;

    private static CubeSites[] cubeSites2 = {CubeSites.ace, CubeSites.ace, CubeSites.ace, CubeSites.ace, CubeSites.ace};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(doUntilFiveOfAKind()));
        System.out.println("Anzahl: " + countGeneral);
        System.out.println("Grande: " + countFourOfAKind);

        System.out.println(0);
        System.out.println(0);
        System.out.println(0);
        System.out.println(0);
        System.out.println(0);
    }

    private static CubeSites[] doUntilFiveOfAKind() {
        CubeSites[] cubeSites = new CubeSites[5];

        while (!isArraySpecificType(cubeSites, "ace")) {

            for (int i = 0; i < 5; i++) {
                cubeSites[i] = CubeSites.values()[getRandomInt(6)];
            }
            countGeneral++;
            if(areArrayValuesIdentical(cubeSites)) countFourOfAKind++;
        }

        return cubeSites;
    }

    private static int getRandomInt(int max) {
        return (int) Math.floor(Math.random() * max);
    }

    private static boolean areArrayValuesIdentical(CubeSites[] cubeSites) {
        if (cubeSites[0] == null) return false;

        for (int i = 0; i < cubeSites.length - 1; i++) {
            if (cubeSites[i] != cubeSites[i + 1]) return false;
        }
        return true;
    }

    private static boolean isArraySpecificType(CubeSites[] cubeSites, String cubeSite) {
        return areArrayValuesIdentical(cubeSites) && cubeSites[0] == CubeSites.valueOf(cubeSite);
    }

}
