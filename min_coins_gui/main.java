import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 

class Mincoins extends JFrame
{

    //sets text box size
    private JTextField _coin = new JTextField(3);
    private JLabel quarter = new JLabel("");
    private JLabel dime = new JLabel("");
    private JLabel nickle = new JLabel("");
    private JLabel penny = new JLabel("");

    //constructor
    public Mincoins()
    {
        //create calulate button
        JButton calc = new JButton("Calculate");
        calc.addActionListener(new Calclisten());
        _coin.addActionListener(new Calclisten());

        //create clear button
        JButton clear = new JButton("Clear");
        clear.addActionListener(new Clearlisten());

        //create panel, set layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,2,2,2));

        //adds components
        //row1
        panel.add(new JLabel("Enter Change (1-99):"));
        panel.add(_coin);

        //row2
        panel.add(new JLabel("Quarters"));
        panel.add(quarter);

        //row3
        panel.add(new JLabel("Dime"));
        panel.add(dime);

        //row4
        panel.add(new JLabel("Nickle"));
        panel.add(nickle);

        //row5
        panel.add(new JLabel("Penny"));
        panel.add(penny);

        //row6
        panel.add(calc);
        panel.add(clear);

        //sets windows attributes
        setContentPane(panel);
        pack();
        setTitle("Minimum Coins");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    //sets calc listen behavior 
    class Calclisten implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            try
            {
                String strcoin = _coin.getText();
                int coin_ammount = Integer.parseInt(strcoin);

                int[] coinarray = {0,0,0,0};
                //checks it the input is zero
                if(coin_ammount >= 5)
                {
                    while(coin_ammount >= 25)
                    {
                        coin_ammount = coin_ammount - 25;
                        coinarray[0] = coinarray[0] + 1;
                    }
                    while(coin_ammount >= 10)
                    {
                        coin_ammount = coin_ammount - 10;
                        coinarray[1] = coinarray[1] + 1;
                    }
                    while(coin_ammount >= 5)
                    {
                        coin_ammount = coin_ammount - 5;
                        coinarray[2] = coinarray[2] + 1;
                    }
                }
                coinarray[3] = coin_ammount;

                quarter.setText("" + coinarray[0]);
                dime.setText("" + coinarray[1]);
                nickle.setText("" + coinarray[2]);
                penny.setText("" + coinarray[3]);
            }
            catch(Exception e)
            {
                System.out.println("massive error");
            }
        }
    }

    //sets clear listen behavior 
    class Clearlisten implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            quarter.setText("");
            dime.setText("");
            nickle.setText("");
            penny.setText("");
        }
    }

    public static void main(String[] args)
    {
        Mincoins window = new Mincoins();
        window.setVisible(true);
    }

    
}