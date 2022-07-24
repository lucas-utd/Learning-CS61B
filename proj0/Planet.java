public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img)
    {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p)
    {
        this(p.xxPos, p.yyPos, p.xxVel, p.yyVel,
                p.mass, p.imgFileName);
//        xxPos = p.xxPos;
//        yyPos = p.yyPos;
//        xxVel = p.xxVel;
//        yyVel = p.yyVel;
//        mass = p.mass;
//        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p)
    {
        double xDistance = Math.abs(xxPos - p.xxPos);
        double yDistance = Math.abs(yyPos - p.yyPos);

        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }

    public double calcForceExertedBy(Planet p)
    {
        double gValue = 6.67e-11;
        return gValue * mass * p.mass / (Math.pow(calcDistance(p), 2));
    }

    public double calcForceExertedByX(Planet p)
    {
        double xDirect = p.xxPos - xxPos;

        return calcForceExertedBy(p) * xDirect / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p)
    {
        double yDirect = p.yyPos - yyPos;

        return calcForceExertedBy(p) * yDirect / calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] planets)
    {
       double res = 0.0;
       for (Planet p : planets) {
           if (!this.equals(p)) {
               res += calcForceExertedByX(p);
           }
       }
       return res;
    }

    public double calcNetForceExertedByY(Planet[] planets)
    {
        double res = 0.0;
        for (Planet p : planets) {
            if (!this.equals(p)) {
                res += calcForceExertedByY(p);
            }
        }
        return res;
    }

    public void update(double dt, double fX, double fY)
    {
        double aX = fX / mass;
        double aY = fY / mass;

        xxVel += dt * aX;
        yyVel += dt * aY;

        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }

    public void draw()
    {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
