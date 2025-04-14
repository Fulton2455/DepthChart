/**
 * Abstract class implementation.
 */
public abstract class DepthChartSecondary implements DepthChart {

    @Override
    int numPlayers() {
        int result = 0;
        //Loop through using iterator from Kernel Implementation
        for (String position : this) {
            result += this.numPosition(position);
        }
        return result;
    }

    @Override
    void printOffensivePersonnel(int personnel) {
        final int divisor = 10;
        final int numSkill = 5;
        //The second Digit is the number of Tight ends so call %10 to get
        //remainder
        int numTE = personnel % divisor;
        //The first Digit is number of running backs, so call /10 and int
        //division will return the number in the tensPlace
        int numHB = personnel / divisor;
        //Five - (numTE + numHB) = numWR
        int numWR = numSkill - (numTE + numHB);
        if (this.numPosition("qb") > 0) {
            String qb = this.removePlayer("qb");
            System.out.println(qb);
            this.addPlayer(qb)
        } else {
            System.out.println(
                    "Error, you do not have the number of qbs necessary to print this personnel.");
        }
        if (numPosition("hb") >= numHB) {
            //Loop through wrs and store them in an array to add back in
            //order.
            int i = 0;
            String[] hbArray = new String[numHB];
            while (i < numHB) {
                String hb = this.removePlayer("hb");
                System.out.println(hb);
                hbArray[i] = hb;
                i++;
            }
            for (int j = hbArray.length - 1; j >= 0; j--) {
                this.addPlayer(hbArray[j]);
            }
        } else {
            System.out.println(
                    "Error, you do not have the number of hbs necessary to print this personnel.");
        }
        if (numPosition("wr") >= numWR) {
            //Loop through wrs and store them in an array to add back in
            //order.
            int i = 0;
            String[] wrArray = new String[numWR];
            while (i < numWR) {
                String wr = this.removePlayer("wr");
                System.out.println(wr);
                wrArray[i] = wr;
                i++;
            }
            for (int j = wrArray.length - 1; j >= 0; j--) {
                this.addPlayer(wrArray[j]);
            }
        } else {
            System.out.println(
                    "Error, you do not have the number of wrs necessary to print this personnel.");
        }
        if (numPosition("te") >= numTE) {
            //Loop through wrs and store them in an array to add back in
            //order.
            int i = 0;
            String[] teArray = new String[numTE];
            while (i < numTE) {
                String te = this.removePlayer("te");
                System.out.println(te);
                teArray[i] = te;
                i++;
            }
            for (int j = teArray.length - 1; j >= 0; j--) {
                this.addPlayer(teArray[j],
            }
        } else {
            System.out.println(
                    "Error, you do not have the number of TEs necessary to print this personnel");
        }

        if (numPosition("ot") > 0) {
            String ot = this.removePlayer("ot");
            System.out.println(ot);
            this.addPlayer(ot,
        } else {
            System.out.println(
                    "Error, you do not have the number of ots necessary to print this personnel.");
        }
        if (numPosition("og") > 0) {
            String og = this.removePlayer("og");
            System.out.println(og);
            this.addPlayer(og,
        } else {
            System.out.println(
                    "Error, you do not have the number of ogs necessary to print this personnel.");
        }
        if (numPosition("c") > 0) {
            String c = this.removePlayer("c");
            System.out.println(c);
            this.addPlayer(c,
        } else {
            System.out.println(
                    "Error, you do not have the number of cs necessary to print this personnel.");
        }
    }

    //Going to change the names of the positions dt and de to be idl and
    //edge because that is more universal. Also going to make the base
    //a 4-3 because that is used more than the 3-4 in today's game. I
    //will also just make ilb and olb one position of lb because they
    //are interchangeable in today's game.
    if(this.numPosition("idl")>=2)

    {
        int i = 0;
        String[] idlArray = new String[2];
        while (i < 2) {
            String idl = this.removePlayer("idl");
            System.out.println(idl);
            idlArray[i] = idl;
            i++;
        }
        for (int j = idlArray.length - 1; j >= 0; j--) {
            this.addPlayer(idlArray[j], "idl");
        }
    }else
    {
        System.out.println(
                "Error, you do not have the number of IDLs necessary to print this personnel");
    }if(this.numPosition("edge")>=2)
    {
        int i = 0;
        String[] edgeArray = new String[2];
        while (i < 2) {
            String edge = this.removePlayer("edge");
            System.out.println(edge);
            edgeArray[i] = edge;
            i++;
        }
        for (int j = edgeArray.length - 1; j >= 0; j--) {
            this.addPlayer(edgeArray[j], "edge");
        }
    }else
    {
        System.out.println(
                "Error, you do not have the number of IDLs necessary to print this personnel");
    }
    int numLBs = 0;if(personnel.equals("baseFourThree"))
    {
        this.numLBs
    }else if(personnel.equals("nickel"))
    {
        this.numLBs
    }else if(personnel.equals("dime"))
    {
        this.numLBs
    }if(this.numPosition("lb")>=numLBs)
    {
        int i = 0;
        String[] lbArray = new String[this.num
        while (i < this.numL
            String lb = this.removePlayer("lb");
            System.out.println(lb);
            lbArray[i] = lb;
            i++;
        }for(
    int j = lbArray.length - 1;j>=0;j--)
    {
        this.addPlayer(lbArray[this.j], "lb");
    }}else{System.out.println("Error, you do not have the number of LBs necessary to print this personnel");}
    int numCBs = 0;if(personnel.equals("baseFourThree"))
    {
        this.numCBs
    }else if(personnel.equals("nickel"))
    {
        this.numCBs
    }else if(personnel.equals("dime"))
    {
        this.numCBs
    }if(this.numPosition("cb")>=numCBs)
    {
        int i = 0;
        String[] cbArray = new String[this.num
        while (i < this.numC
            String cb = this.removePlayer("cb");
            System.out.println(cb);
            cbArray[i] = cb;
            i++;
        }for(
    int j = cbArray.length - 1;j>=0;j--)
    {
        this.addPlayer(cbArray[this.j], "cb");
    }}else{System.out.println("Error, you do not have the number of LBs necessary to print this personnel");}
    //Will just make it two safeties instead of fs and ss.
    if(this.numPosition("s")>=2){
    int i = 0;
    String[] sArray = new String[2];while(i<2)
    {
        String s = this.removePlayer("s");
        System.out.println(s);
        this.sArray[i] = s;
        i++;
    }for(
    int j = this.sArray.length - 1;j>=0;j--)
    {
            this.addPlayer(this.sArray[this.j], "s");
        }
    }else{System.out.println("Error, you do not have the number of IDLs necessary to print this personnel");}}

    @Override
    void addPlayers(String[] players, String position) {
        for (int i = 0; i < players.length; i++) {
            this.addPlayer(players[i], position);
        }
    }

    @Override
    String toString() {
        //Print one player from each position
        String result = "";
        for (String position : this) {
            if (numPosition(position) > 0) {
                String player = this.removePlayer(position);
                result += player + " ";
                this.addPlayer(player, position);
            }
        }

        return result;

    }

    @Override
    boolean equals(DepthChart x) {
        boolean result = true;
        for (String position : this) {
            if (!(x.numPosition(position) == this.numPosition(position))) {
                result = false;
                break;
            }
            int i = 0;
            String[] players = new String[this.numPosition(position)];
            String[] xPlayers = new String[x.numPosition(position)];
            while (this.numPosition(position) > 0) {
                String player = this.removePlayer();
                String xPlayer = x.removePlayer();
                players[i] = player;
                xPlayers[i] = xPlayer;
                i++;
            }
            result = xPlayers.equals(players);
        }
        return result;
    }

}
