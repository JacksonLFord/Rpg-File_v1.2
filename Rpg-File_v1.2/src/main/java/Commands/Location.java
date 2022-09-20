package Commands;

public class Location {

        //"Cottage", "Center", "North", "South", "East", "West", "Exit");
        public static String Forest() {
            return "You find yourself alone in a Vast forest,\n be wary traveler!";
        }

        public static String ForestCottage() {
            return "A disgusting shack stands before you,\n do you  dare go in?";
        }

        public static String ForestCenter() {
            return "You stand in the center of the vast\n forest";
        }

        public static String ForestNorth() {
            return "You stand in the North of the dark \nforest";
        }

        public static String ForestSouth() {
            return "You stand in the South of the large\n forest";
        }

        public static String ForestEast() {
            return "You stand in the East of the Forest";
        }

        public static String ForestWest() {
            return "You stand in the West of the Forest";
        }

        public static String ForestExit() {
            return "The Exit of the Forest.";
        }

        public static String mainLocation(String sublocation) {
            if (sublocation.equalsIgnoreCase("Cottage")) {
                return "Forest";
            }
            if (sublocation.equalsIgnoreCase("Center")) {
                return "Forest";
            }
            if (sublocation.equalsIgnoreCase("North")) {
                return "Forest";
            }
            if (sublocation.equalsIgnoreCase("South")) {
                return "Forest";
            }
            if (sublocation.equalsIgnoreCase("East")) {
                return "Forest";
            }
            if (sublocation.equalsIgnoreCase("West")) {
                return "Forest";
            }
            return "false";
        }


    }


