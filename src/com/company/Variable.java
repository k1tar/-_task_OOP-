package com.company;

public class Variable {
    public String str;
    public int rimcheck = 0, intvar = 0;


    public void checkdata () {
        int i;
        i = str.indexOf('I');
        if ( i != -1 ) {
            rimcheck = 1;
        } else {
            i = str.indexOf('V');
            if ( i != -1 ) {
                rimcheck = 1;
            } else {
                i = str.indexOf('X');
                if ( i != -1) {
                    rimcheck = 1;
                } else {
                    i = str.indexOf('C');
                    if ( i != -1) {
                        rimcheck = 1;
                    }   else {
                        i = str.indexOf('D');
                        if ( i != -1) {
                            rimcheck = 1;
                        } else {
                            i = str.indexOf('M');
                            if ( i != -1) {
                                rimcheck = 1;
                            } else {
                                i = str.indexOf('i');
                                if ( i != -1) {
                                    rimcheck = 1;
                                } else {
                                    i = str.indexOf('v');
                                    if ( i != -1) {
                                        rimcheck = 1;
                                    } else {
                                        i = str.indexOf('x');
                                        if ( i != -1) {
                                            rimcheck = 1;
                                        } else {
                                            i = str.indexOf('c');
                                            if ( i != -1) {
                                                rimcheck = 1;
                                            } else {
                                                i = str.indexOf('d');
                                                if ( i != -1) {
                                                    rimcheck = 1;
                                                } else {
                                                    i = str.indexOf('m');
                                                    if ( i != -1) {
                                                        rimcheck = 1;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if ( rimcheck == 1) {
            String[] rim= new String[] {null , "I","II","III","IV","V","VI","VII","VIII","IX","X"};
            for (int j = 1; j < 11; j++) {
                if (str.equals(rim[j])) {
                    intvar = j;
                    return;
                }
            }
            return;
        }
        else {
            i = str.indexOf(' ');
            if (i != -1) {
                intvar = 0;
                return;
            }
            intvar = Integer.parseInt(str);
            if (intvar < 1 || intvar > 10)
                intvar = 0;
            return;
        }
    }
}
