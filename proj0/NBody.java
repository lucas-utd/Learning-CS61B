public class NBody {

    public static double readRadius(String input)
    {
        In in = new In(input);
//        String nextLine;
//        do {
//            nextLine = in.readLine();
//        } while (nextLine.isBlank());

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
        double T = 0;
        double dt = 0;
        try {
            T = Double.parseDouble(args[0]);
            dt = Double.parseDouble(args[1]);
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        int numOfPlanets = planets.length;

        // Enable Double Buffering
        StdDraw.enableDoubleBuffering();

        StdDraw.setScale(-radius, radius);

        StdAudio.play("audio/2001.mid");

        double time = 0;
        while (time <= T) {
            double[] xForces = new double[numOfPlanets];
            double[] yForces = new double[numOfPlanets];
            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            // Clears the drawing windows.
            StdDraw.clear();
            // Draws the background
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p : planets) {
                p.draw();
            }
            /* Shows the drawing to the screen, and waits 2000 milliseconds. */
            StdDraw.show();
            StdDraw.pause(10);

            time += dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
