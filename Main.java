public class Main {
    public static void main(String[] args) {
        SuperBowl sbLIII = new SuperBowl("Feb 3, 2019", "LIII", "Patriots", 3.2, "Rams", 4.1);

        System.out.println("Average yards per play in the game: " + sbLIII.findAVGOfGame());
        sbLIII.compareTeams();
    }
}
