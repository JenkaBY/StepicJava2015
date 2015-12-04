package module3.lesson3.step12;

/**
 * Created by asu7 on 29.09.2015.
 */
public class Robot
{
        private int x;
        private int y;
        private Direction direction;

        public Robot(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public Direction getDirection() {
            return direction;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void turnLeft() {
            switch (direction) {
                case DOWN:
                    System.out.println("turning left");
                    direction = Direction.RIGHT;
                    break;
                case LEFT:
                    System.out.println("turning left");
                    direction = Direction.DOWN;
                    break;
                case RIGHT:
                    System.out.println("turning left");
                    direction = Direction.UP;
                    break;
                case UP:
                    System.out.println("turning left");
                    direction = Direction.LEFT;
                    break;
                default:
                    break;
            }
        }

        public void turnRight() {
            switch (direction) {
                case DOWN:
                    System.out.println("turning right");
                    direction = Direction.LEFT;
                    break;
                case LEFT:
                    System.out.println("turning right");
                    direction = Direction.UP;
                    break;
                case RIGHT:
                    System.out.println("turning right");
                    direction = Direction.DOWN;
                    break;
                case UP:
                    System.out.println("turning right");
                    direction = Direction.RIGHT;
                    break;
                default:
                    break;
            }
        }

        public void stepForward() {
            switch (direction) {
                case DOWN:
                    --y;
                    System.out.println("moving down");
                    break;
                case LEFT:
                    --x;
                    System.out.println("moving left");
                    break;
                case RIGHT:
                    ++x;
                    System.out.println("moving right");
                    break;
                case UP:
                    System.out.println("moving up");
                    ++y;
                    break;
                default:
                    break;
            }
        }

        public static void moveRobot(Robot robot, int toX, int toY) {

            while (( robot.getX()!= toX) | ( robot.getY()!= toY))
            {
                if (toX > robot.getX())
                {
                    while (robot.getDirection()!= Direction.RIGHT)
                    {
                        robot.turnRight();
                    }
                    while (robot.getX()!= toX) {
                        robot.stepForward();
                    }
                    System.out.println(robot.getX());
                }
                else if (toX < robot.getX())
                {
                    while (robot.getDirection () != Direction.LEFT)
                    {
                        robot.turnRight();
                    }
                    while (robot.getX()!= toX) {
                        robot.stepForward();
                    }
                    System.out.println(robot.getX());
                }
                if (toY > robot.getY())
                {
                    while (robot.getDirection () != Direction.UP)
                    {
                        robot.turnRight();
                    }
                    while (robot.getY()!= toY) {
                        robot.stepForward();
                    }
                    System.out.println(robot.getY());
                }
                if (toY < robot.getY())
                {
                    while (robot.getDirection () != Direction.DOWN)
                    {
                        robot.turnRight();
                    }

                    while (robot.getY()!= toY) {
                        robot.stepForward();
                    }
                    System.out.println(robot.getY());
                }
            }
            System.out.println("Robot in position X = " +robot.getX()+ " Y=" + robot.getY());

        }
}

