package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword1 = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        int[][] crossword2 = new int[][]{
                {'r', 'm', 'a', 'r', 'r', 'e'},
                {'m', 'e', 'a', 'e', 'e', 'm'},
                {'s', 'a', 'm', 'e', 's', 'o'},
                {'m', 'o', 'p', 'o', 'o', 'h'},
                {'h', 'r', 'e', 'm', 'h', 'h'}
        };
        for (Word word : detectAllWords(crossword2, "home", "same", "homer"))
        {
            System.out.println(word.toString());
        }


        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */

    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        for (int x = 0; x < words.length; x++) {

            String word = words[x];
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[0].length; j++) {
                    if (crossword[i][j] == word.charAt(0)) {
                        int[] end = func(crossword, word, i, j);
                        if (end != null) {
                            Word wrd = new Word(words[x]);
                            wrd.setStartPoint(j, i);
                            wrd.setEndPoint(end[1], end[0]);
                            list.add(wrd);
                        }
                    }
                }
            }
        }

        return list;
    }

    public static int[] func(int[][] crossword, String word, int x, int y) {
        int[] end;
        int len = word.length();
        int i = 1;
        int xx = x, yy = y;

            while (xx - 1 >= 0 & yy - 1 >= 0 & i < len) {
                int ch = word.charAt(i);
                if (crossword[xx - 1][yy - 1] == ch) {
                    xx = xx - 1;
                    yy = yy - 1;
                    i++;
                }
                else {
                    break;
                }
            }
            if (i == len) {
                end = new int[2];
                end[0] = xx;
                end[1] = yy;
                return end;
            }
            i = 1;
            xx = x; yy = y;
            while (xx - 1 >= 0 & yy + 1 < crossword[0].length & i < len) {
                int ch = word.charAt(i);
                if (crossword[xx - 1][yy + 1] == ch) {
                    xx = xx - 1;
                    yy = yy + 1;
                    i++;
                }
                else {
                    break;
                }
            }
            if (i == len) {
                end = new int[2];
                end[0] = xx;
                end[1] = yy;
                return end;
            }
            i = 1;
            xx = x; yy = y;
            while (xx - 1 >= 0 & i < len) {
                int ch = word.charAt(i);
                if (crossword[xx - 1][yy] == ch) {
                    xx = xx - 1;
                    i++;
                }
                else {
                    break;
                }
            }
            if (i == len) {
                end = new int[2];
                end[0] = xx;
                end[1] = yy;
                return end;
            }
            i = 1;
            xx = x; yy = y;
            while (yy+1 < crossword[0].length & xx+1 < crossword.length & i < len) {
                int ch = word.charAt(i);
                if (crossword[xx+1][yy+1] == ch) {
                    xx = xx + 1;
                    yy = yy + 1;
                    i++;
                }
                else {
                    break;
                }
            }
            if (i == len) {
                end = new int[2];
                end[0] = xx;
                end[1] = yy;
                return end;
            }
            i = 1;
            xx = x; yy = y;
            while (yy+1 < crossword[0].length & i < len) {
                int ch = word.charAt(i);
                if (crossword[xx][yy+1] == ch) {
                    yy = yy + 1;
                    i++;
                }
                else {
                    break;
                }
            }
            if (i == len) {
                end = new int[2];
                end[0] = xx;
                end[1] = yy;
                return end;
            }
            i = 1;
            xx = x; yy = y;
            while (yy-1 >= 0 & i < len) {
                int ch = word.charAt(i);
                if (crossword[xx][yy-1] == ch) {
                    yy = yy - 1;
                    i++;
                }
                else {
                    break;
                }
            }
            if (i == len) {
                end = new int[2];
                end[0] = xx;
                end[1] = yy;
                return end;
                }
            i = 1;
            xx = x; yy = y;
            while (xx+1 < crossword.length & i < len) {
                int ch = word.charAt(i);
                if (crossword[xx+1][yy] == ch) {
                    xx = xx + 1;
                    i++;
                }
                else {
                    break;
                }
            }
            if (i == len) {
                end = new int[2];
                end[0] = xx;
                end[1] = yy;
                return end;
            }
            i = 1;
            xx = x; yy = y;
            while (xx+1 < crossword.length & yy-1 >= 0 & i < len) {
                int ch = word.charAt(i);
                if (crossword[xx+1][yy-1] == ch) {
                    xx = xx + 1;
                    yy = yy - 1;
                    i++;
                }
                else {
                    break;
                }
            }
            if (i == len) {
                end = new int[2];
                end[0] = xx;
                end[1] = yy;
                return end;
            }

            return null;
    }



    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
