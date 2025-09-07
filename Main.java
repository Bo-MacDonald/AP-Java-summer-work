public class Main {
    public static void main(String[] args) {
        //Example of SuperBowl object
        SuperBowl sbLIII = new SuperBowl("Feb 3, 2019", "LIII", "Patriots", 6.0, "Rams", 4.3);

        System.out.println("Average yards per play in the game: " + sbLIII.findAVGOfGame());
        sbLIII.compareTeams();
    }
}
