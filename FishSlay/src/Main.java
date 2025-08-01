
import javax.swing.*;
import java.awt.*;

public class Main {
    JFrame f;
    DrawingPanel p;
    JSlider stx, sty, srot, sscale;
    int tx = 100, ty = 100;
    double rot = 0.0, scale = 1.0;
    int n = 13;
    int[] x = new int[] { 0, -8, -50, -50, -8, -4, -20, 20, 4, 8, 50, 50, 8 };
    int[] y = new int[] { -40, -10, -10, 0, 10, 40, 50, 50, 40, 10, 0, -10, -10 };
    class DrawingPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            java.awt.geom.AffineTransform at0 = g2.getTransform();
            g2.translate(tx, ty);
            g2.rotate(rot);
            g2.scale(scale, scale);
            g.setColor(Color.blue);
            g.fillPolygon(x, y, n);
            g2.setTransform(at0);
            g.setColor(Color.red);
            g.drawRect(50, 50, 100, 100);
        }
    }
    Main() {
        f = new JFrame();
        f.setFocusable(true);
        f.setVisible(true);
        p = new DrawingPanel();
        f.getContentPane().add(p, BorderLayout.CENTER);
        stx = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);
        sty = new JSlider(JSlider.VERTICAL, 0, 200, 100);
        sty.setInverted(true);
        srot = new JSlider(JSlider.HORIZONTAL, -180, +180, 0);
        sscale = new JSlider(JSlider.VERTICAL, 0, 100, 100);
        f.getContentPane().add(stx, BorderLayout.SOUTH);
        f.getContentPane().add(sty, BorderLayout.WEST);
        f.getContentPane().add(srot, BorderLayout.NORTH);
        f.getContentPane().add(sscale, BorderLayout.EAST);
        stx.addChangeListener(e -> {
            tx = stx.getValue();
            f.repaint();
        });
        sty.addChangeListener(e -> {
            ty = sty.getValue();
            f.repaint();
        });
        srot.addChangeListener(e -> {
            rot = (Math.PI / 180) * srot.getValue();
            f.repaint();
        });
        sscale.addChangeListener(e -> {
            scale = (1.0 / 100) * sscale.getValue();
            f.repaint();
        });
        f.setSize(new Dimension(250 + 16, 250 + 38));
    }
    public static void main(String[] args) {
        Main m = new Main();
    }
}
