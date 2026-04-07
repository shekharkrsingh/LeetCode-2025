class Robot {

    private Integer width;
    private Integer height;
    private Integer x = 0;
    private Integer y = 0;
    private String dir;
    public Robot(int width, int height) {
        this.width = width - 1;
        this.height = height - 1;
        this.dir = "East";
    }

    public void step(int num) {
        int p = 2 * (height + width);
        if (num >= p) {
            num = num % p;
            if (num == 0) {
                num = p;
            }
        }
        if (x == width && dir == "East")dir = "North";
        else if (x == 0 && dir == "West")dir = "South";
        else if (y == height && dir == "North")dir = "West";
        else if (y == 0 && dir == "South")dir = "East";

        if (dir == "East" && x + num > width) {
            int val = num - width + x;
            x = width;
            step(val);
            return;
        } else if (dir == "West" && x < num) {
            int val = num - x;
            x = 0;
            step(val);
            return;
        } else if (dir == "North" && y + num > height) {
            int val = num - height + y;
            y = height;
            step(val);
            return;
        } else if (dir == "South" && y < num) {
            int val = num - y;
            y = 0;
            step(val);
            return;
        }

        if (dir == "East" && x + num <= width) x += num;
        if (dir == "West" && x >= num) x = x - num;
        if (dir == "North" && y + num <= height) y += num;
        if (dir == "South" && y >= num) y -= num;

    }

    public int[] getPos(){ return new int[] { x, y };}

    public String getDir() {return this.dir;}
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */