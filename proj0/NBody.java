public class NBody {

    public static double readRadius(String input)
    {
        In in = new In(input);
        int _int = in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String input)
    {
        In in = new In(input);
        int num = in.readInt();
        Planet[] res = new Planet[num];
        double _double = in.readDouble();
        for (int i = 0; i < num; i++) {
            Planet tmp = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(),
                    in.readString());
            res[i] = tmp;
        }
        return res;
    }

    public static void main(String[] args)
    {
        if (args.length != 3) {
            System.out.println("It need 3 arguments!");
        }
        try {
            double T = Double.parseDouble(args[0]);
            double dt = Double.parseDouble(args[1]);
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setScale(-radius, radius);
        // Clears the drawing windows.
        StdDraw.clear();

        StdDraw.picture(0, 0, "images/starfield.jpg");
//        for (Planet p : planets) {
//            StdDraw.picture(p.xxPos, p.yyPos, "images/" + p.imgFileName);
//        }
    }
}
