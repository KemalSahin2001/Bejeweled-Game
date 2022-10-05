public class GameTools {
    public void Match(Integer row, Integer column) {
        boolean first = false;
        boolean second = false;
        boolean third = false;
        if (Game.Map.get(row).get(column) instanceof Jewel) {
            Jewel jwl = (Jewel) Game.Map.get(row).get(column);
            switch (jwl.getShape()) {
                case "D":
                    try {
                        if (Game.Map.get(row - 1).get(column - 1).equals(jwl) && Game.Map.get(row - 2).get(column - 2).equals(jwl)) {
                            first = LeftUpDiag(row, column, jwl);
                        }
                    } catch (Exception e) {}
                    try {
                        if (Game.Map.get(row + 1).get(column + 1).equals(jwl) && Game.Map.get(row + 2).get(column + 2).equals(jwl) && !first) {
                            second = RightDownDiag(row, column, jwl);
                        }
                    } catch (Exception e) {}
                    try {
                        if (Game.Map.get(row - 1).get(column + 1).equals(jwl) && Game.Map.get(row - 2).get(column + 2).equals(jwl) && !first && !second) {
                            third = RightUpDiag(row, column, jwl);
                        }
                    } catch (Exception e) {}
                    try {
                        if (Game.Map.get(row + 1).get(column - 1).equals(jwl) && Game.Map.get(row + 2).get(column - 2).equals(jwl) && !first && !second && !third) {
                            LeftDownDiag(row, column, jwl);
                        }
                    } catch (Exception e) {}
                    break;
                case "S":
                    try {
                        if (Game.Map.get(row).get(column - 1).equals(jwl) && Game.Map.get(row).get(column - 2).equals(jwl)) {
                            first = Left(row, column, jwl);
                        }
                    } catch (Exception e) {}
                    try {
                        if (Game.Map.get(row).get(column + 1).equals(jwl) && Game.Map.get(row).get(column + 2).equals(jwl) && !first) {
                            Right(row, column, jwl);
                        }
                    } catch (Exception e) {}
                    break;
                case "T":
                    try {
                        if (Game.Map.get(row - 1).get(column).equals(jwl) && Game.Map.get(row - 2).get(column).equals(jwl)) {
                            first = Up(row, column, jwl);
                        }
                    } catch (Exception e) {}
                    try {
                        if (Game.Map.get(row + 1).get(column).equals(jwl) && Game.Map.get(row + 2).get(column).equals(jwl) && !first) {
                            Down(row, column, jwl);
                        }
                    } catch (Exception e) {}
                    break;
                case "W":
                    WildCard(row, column, jwl);
            }
        } else {            
            MathematicalSymbols MathSymbol = (MathematicalSymbols) Game.Map.get(row).get(column);
            switch (MathSymbol.getShape()) {
                case "/":
                    try {
                        if (Game.Map.get(row - 1).get(column + 1) instanceof MathematicalSymbols && Game.Map.get(row - 2).get(column + 2) instanceof MathematicalSymbols) {
                            first = RightUpDiag(row, column, MathSymbol);
                        }
                    } catch (Exception e) {}
                    try {
                        if (Game.Map.get(row + 1).get(column - 1) instanceof MathematicalSymbols && Game.Map.get(row + 2).get(column - 2) instanceof MathematicalSymbols && !first) {
                            LeftDownDiag(row, column, MathSymbol);
                        }
                    } catch (Exception e) {}
                    break;
                case "-":
                    try {
                        if (Game.Map.get(row).get(column - 1) instanceof MathematicalSymbols && Game.Map.get(row).get(column - 2) instanceof MathematicalSymbols) {
                            first = Left(row, column, MathSymbol);
                        }
                    } catch (Exception e) {}
                    try {
                        if (Game.Map.get(row).get(column + 1) instanceof MathematicalSymbols && Game.Map.get(row).get(column + 2) instanceof MathematicalSymbols && !first) {
                            Right(row, column, MathSymbol);
                        }
                    } catch (Exception e) {}
                    break;
                case "+":
                    try {
                        if (Game.Map.get(row).get(column - 1) instanceof MathematicalSymbols && Game.Map.get(row).get(column - 2) instanceof MathematicalSymbols) {
                            first = Left(row, column, MathSymbol);
                        }
                    } catch (Exception e) {}
                    try {
                        if (Game.Map.get(row).get(column + 1) instanceof MathematicalSymbols && Game.Map.get(row).get(column + 2) instanceof MathematicalSymbols && !first) {
                            second = Right(row, column, MathSymbol);
                        }
                    } catch (Exception e) {}
                    try {
                        if (Game.Map.get(row - 1).get(column) instanceof MathematicalSymbols && Game.Map.get(row - 2).get(column) instanceof MathematicalSymbols && !first && !second) {
                            third = Up(row, column, MathSymbol);
                        }
                    } catch (Exception e) {}
                    try {
                        if (Game.Map.get(row + 1).get(column) instanceof MathematicalSymbols && Game.Map.get(row + 2).get(column) instanceof MathematicalSymbols && !first && !second && !third) {
                            Down(row, column, MathSymbol);
                        }
                    } catch (Exception e) {}
                    break;
                case "\\":
                    try {
                        if (Game.Map.get(row - 1).get(column - 1) instanceof MathematicalSymbols && Game.Map.get(row - 2).get(column - 2) instanceof MathematicalSymbols) {
                            first = LeftUpDiag(row, column, MathSymbol);
                        }
                    } catch (Exception e) {}
                    try {
                        if (Game.Map.get(row + 1).get(column + 1) instanceof MathematicalSymbols && Game.Map.get(row + 2).get(column + 2) instanceof MathematicalSymbols && !first) {
                            RightDownDiag(row, column, MathSymbol);
                        }
                    } catch (Exception e) {}
                    break;
                case "|":
                    try {
                        if (Game.Map.get(row - 1).get(column) instanceof MathematicalSymbols && Game.Map.get(row - 2).get(column) instanceof MathematicalSymbols) {
                            first = Up(row, column, MathSymbol);
                        }
                    } catch (Exception e) {}
                    try {
                        if (Game.Map.get(row + 1).get(column) instanceof MathematicalSymbols && Game.Map.get(row + 2).get(column) instanceof MathematicalSymbols && !first) {
                            Down(row, column, MathSymbol);
                        }
                    } catch (Exception e) {}
                    break;
                default:
                    break;
            }            
        }
        SlideSymbols();
    }
    private boolean Up(Integer row, Integer column, Symbol jewel) {
        try {
            Symbol jwl1 = Game.Map.get(row - 1).get(column);
            Symbol jwl2 = Game.Map.get(row - 2).get(column);
            Game.tempPoint = jwl1.getPoint() + jwl2.getPoint() + jewel.getPoint();
            Game.Points += Game.tempPoint;
            Game.Map.get(row).set(column, new Jewel(" "));
            Game.Map.get(row - 1).set(column, new Jewel(" "));
            Game.Map.get(row - 2).set(column, new Jewel(" "));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private boolean Down(Integer row, Integer column, Symbol jewel) {
        try {
            Symbol jwl1 = Game.Map.get(row + 1).get(column);
            Symbol jwl2 = Game.Map.get(row + 2).get(column);
            Game.tempPoint = jwl1.getPoint() + jwl2.getPoint() + jewel.getPoint();
            Game.Points += Game.tempPoint;
            Game.Map.get(row).set(column, new Jewel(" "));
            Game.Map.get(row + 1).set(column, new Jewel(" "));
            Game.Map.get(row + 2).set(column, new Jewel(" "));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private boolean Right(Integer row, Integer column, Symbol jewel) {
        try {
            Symbol jwl1 = Game.Map.get(row).get(column + 1);
            Symbol jwl2 = Game.Map.get(row).get(column + 2);
            Game.tempPoint = jwl1.getPoint() + jwl2.getPoint() + jewel.getPoint();
            Game.Points += Game.tempPoint;
            Game.Map.get(row).set(column, new Jewel(" "));
            Game.Map.get(row).set(column + 1, new Jewel(" "));
            Game.Map.get(row).set(column + 2, new Jewel(" "));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private boolean Left(Integer row, Integer column, Symbol jewel) {
        try {
            Symbol jwl1 = Game.Map.get(row).get(column - 1);
            Symbol jwl2 = Game.Map.get(row).get(column - 2);
            Game.tempPoint = jwl1.getPoint() + jwl2.getPoint() + jewel.getPoint();
            Game.Points += Game.tempPoint;
            Game.Map.get(row).set(column, new Jewel(" "));
            Game.Map.get(row).set(column - 1, new Jewel(" "));
            Game.Map.get(row).set(column - 2, new Jewel(" "));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private boolean LeftUpDiag(Integer row, Integer column, Symbol jewel) {
        try {
            Symbol jwl1 = Game.Map.get(row - 1).get(column - 1);
            Symbol jwl2 = Game.Map.get(row - 2).get(column - 2);
            Game.tempPoint = jwl1.getPoint() + jwl2.getPoint() + jewel.getPoint();
            Game.Points += Game.tempPoint;
            Game.Map.get(row).set(column, new Jewel(" "));
            Game.Map.get(row - 1).set(column - 1, new Jewel(" "));
            Game.Map.get(row - 2).set(column - 2, new Jewel(" "));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private boolean RightDownDiag(Integer row, Integer column, Symbol jewel) {
        try {
            Symbol jwl1 = Game.Map.get(row + 1).get(column + 1);
            Symbol jwl2 = Game.Map.get(row + 2).get(column + 2);
            Game.tempPoint = jwl1.getPoint() + jwl2.getPoint() + jewel.getPoint();
            Game.Points += Game.tempPoint;
            Game.Map.get(row).set(column, new Jewel(" "));
            Game.Map.get(row + 1).set(column + 1, new Jewel(" "));
            Game.Map.get(row + 2).set(column + 2, new Jewel(" "));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private boolean RightUpDiag(Integer row, Integer column, Symbol jewel) {
        try {
            Symbol jwl1 = Game.Map.get(row - 1).get(column + 1);
            Symbol jwl2 = Game.Map.get(row - 2).get(column + 2);
            Game.tempPoint = jwl1.getPoint() + jwl2.getPoint() + jewel.getPoint();
            Game.Points += Game.tempPoint;
            Game.Map.get(row).set(column, new Jewel(" "));
            Game.Map.get(row - 1).set(column + 1, new Jewel(" "));
            Game.Map.get(row - 2).set(column + 2, new Jewel(" "));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private boolean LeftDownDiag(Integer row, Integer column, Symbol jewel) {
        try {
            Symbol jwl1 = Game.Map.get(row + 1).get(column - 1);
            Symbol jwl2 = Game.Map.get(row + 2).get(column - 2);
            Game.tempPoint = jwl1.getPoint() + jwl2.getPoint() + jewel.getPoint();
            Game.Points += Game.tempPoint;
            Game.Map.get(row).set(column, new Jewel(" "));
            Game.Map.get(row + 1).set(column - 1, new Jewel(" "));
            Game.Map.get(row + 2).set(column - 2, new Jewel(" "));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private void WildCard(Integer row, Integer column, Symbol jewel) {
        Boolean check = false;

        try {
            Symbol jwlup1 = Game.Map.get(row - 1).get(column);
            Symbol jwlup2 = Game.Map.get(row - 2).get(column);

            if ((jwlup1 instanceof Jewel && jwlup2 instanceof Jewel)) {
                if (jwlup1.getShape().equals("W") || jwlup2.getShape().equals("W")) {
                    check = Up(row, column, jewel);
                } else if (jwlup1.equals(jwlup2)) {
                    check = Up(row, column, jewel);
                }
            }
        } catch (Exception e) {}
        try {
            Symbol jwldown1 = Game.Map.get(row + 1).get(column);
            Symbol jwldown2 = Game.Map.get(row + 2).get(column);

            if ((jwldown1 instanceof Jewel && jwldown2 instanceof Jewel && !check)) {
                if (jwldown1.getShape().equals("W") || jwldown2.getShape().equals("W")) {
                    check = Down(row, column, jewel);
                } else if (jwldown1.equals(jwldown2)) {
                    check = Down(row, column, jewel);
                }
            }
        } catch (Exception e) {}
        try {
            Symbol jwlleft1 = Game.Map.get(row).get(column - 1);
            Symbol jwlleft2 = Game.Map.get(row).get(column - 2);

            if ((jwlleft1 instanceof Jewel && jwlleft2 instanceof Jewel && !check)) {
                if (jwlleft1.getShape().equals("W") || jwlleft2.getShape().equals("W")) {
                    check = Left(row, column, jewel);
                } else if (jwlleft1.equals(jwlleft2)) {
                    check = Left(row, column, jewel);
                }
            }
        } catch (Exception e) {}
        try {
            Symbol jwlright1 = Game.Map.get(row).get(column + 1);
            Symbol jwlright2 = Game.Map.get(row).get(column + 2);

            if ((jwlright1 instanceof Jewel && jwlright2 instanceof Jewel && !check)) {
                if (jwlright1.getShape().equals("W") || jwlright2.getShape().equals("W")) {
                    check = Right(row, column, jewel);
                } else if (jwlright1.equals(jwlright2)) {
                    check = Right(row, column, jewel);
                }
            }
        } catch (Exception e) {}
        try {
            Symbol jwlleftUp1 = Game.Map.get(row - 1).get(column - 1);
            Symbol jwlleftUp2 = Game.Map.get(row - 2).get(column - 2);

            if ((jwlleftUp1 instanceof Jewel && jwlleftUp2 instanceof Jewel && !check)) {
                if (jwlleftUp1.getShape().equals("W") || jwlleftUp2.getShape().equals("W")) {
                    check = LeftUpDiag(row, column, jewel);
                } else if (jwlleftUp1.equals(jwlleftUp2)) {
                    check = LeftUpDiag(row, column, jewel);
                }
            }
        } catch (Exception e) {}
        try {
            Symbol jwlrightDown1 = Game.Map.get(row + 1).get(column + 1);
            Symbol jwlrightDown2 = Game.Map.get(row + 2).get(column + 2);

            if ((jwlrightDown1 instanceof Jewel && jwlrightDown2 instanceof Jewel && !check)) {
                if (jwlrightDown1.getShape().equals("W") || jwlrightDown2.getShape().equals("W")) {
                    check = RightDownDiag(row, column, jewel);
                } else if (jwlrightDown1.equals(jwlrightDown2)) {
                    check = RightDownDiag(row, column, jewel);
                }
            }
        } catch (Exception e) {}
        try {
            Symbol jwlrightUp1 = Game.Map.get(row - 1).get(column + 1);
            Symbol jwlrightUp2 = Game.Map.get(row - 2).get(column + 2);

            if ((jwlrightUp1 instanceof Jewel && jwlrightUp2 instanceof Jewel && !check)) {
                if (jwlrightUp1.getShape().equals("W") || jwlrightUp2.getShape().equals("W")) {
                    check = RightUpDiag(row, column, jewel);
                } else if (jwlrightUp1.equals(jwlrightUp2)) {
                    check = RightUpDiag(row, column, jewel);
                }
            }
        } catch (Exception e) {}
        try {
            Symbol jwlleftDown1 = Game.Map.get(row + 1).get(column - 1);
            Symbol jwlleftDown2 = Game.Map.get(row + 2).get(column - 2);

            if ((jwlleftDown1 instanceof Jewel && jwlleftDown2 instanceof Jewel && !check)) {
                if (jwlleftDown1.getShape().equals("W") || jwlleftDown2.getShape().equals("W")) {
                    check = LeftDownDiag(row, column, jewel);
                } else if (jwlleftDown1.equals(jwlleftDown2)) {
                    check = LeftDownDiag(row, column, jewel);
                }
            }
        } catch (Exception e) {}
    }
    private void SlideSymbols() {
        for (int q = 0; q < Game.Map.size(); q++) {
            for (int i = 0; i < Game.Map.size() - 1; i++) {
                for (int j = 0; j < Game.Map.get(0).size(); j++) {
                    if (Game.Map.get(i + 1).get(j).getShape().equals(" ")) {
                        String temp = Game.Map.get(i).get(j).getShape();
                        switch (temp) {
                            case "/":
                            case "-":
                            case "+":
                            case "\\":
                            case "|":
                                Game.Map.get(i + 1).set(j, new MathematicalSymbols(temp));
                                Game.Map.get(i).set(j, new MathematicalSymbols(" "));
                                break;
                            case "D":
                            case "S":
                            case "T":
                            case "W":
                                Game.Map.get(i + 1).set(j, new Jewel(temp));
                                Game.Map.get(i).set(j, new Jewel(" "));
                            default:
                                break;
                        }
                    }
                }
            }
        }

    }
}