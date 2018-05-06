package org.cx.designpattern.signleton;

/**
 * @author grass
 */
public enum Color {
    RED() {
        private int r = 255;
        private int g = 0;
        private int b = 0;

        @Override
        public String toString() {
            return "$classname{" +
                    "r=" + r +
                    ", g=" + g +
                    ", b=" + b +
                    '}';
        }
    }, BLACK() {
        private int r = 0;
        private int g = 0;
        private int b = 0;

        @Override
        public String toString() {
            return "$classname{" +
                    "r=" + r +
                    ", g=" + g +
                    ", b=" + b +
                    '}';
        }
    }, WHITE() {
        private int r = 255;
        private int g = 255;
        private int b = 255;

        @Override
        public String toString() {
            return "$classname{" +
                    "r=" + r +
                    ", g=" + g +
                    ", b=" + b +
                    '}';
        }
    };

}
