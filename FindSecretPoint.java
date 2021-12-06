class FindSecretPoint{

    /*using binary search, this method finds the secret point and returns it*/
    public static int[] findTrue (boolean[][] tmp)
    {
        int minR = 0; //is currently first row's index
        int minC = 0; // is currently first column's index
        int maxR = tmp.length - 1; //is currently last row's index
        int maxC = tmp.length - 1; // is currently last column's index (the array is a quare)
        int row = maxR/2; //represents row
        int col = maxC/2; //represents column
        int [] arr = {0,0};

        if (tmp.length < 6)
        {
            System.out.println("Error: The array is too small");
        }

        while ((ask(row,col)[0] != 0) || (ask(row,col)[1] != 0)) //while current row,col not the point
        {
            if (ask(row,col)[0] == 1) //the row value of the truth point is bigger than row
            {
                minR = row+1;
                row = (minR +maxR)/2;
            }
            else if (ask(row,col)[0] == (-1)) //the row value of the truth point is smaller than row
            {
                maxR = row-1;
                row = (minR +maxR)/2;
            }
            if (ask(row,col)[1] == 1) //the column value of the truth point is bigger than col
            {
                minC = col+1;
                col = (minC +maxC)/2;
            }
            else if (ask(row,col)[1] == (-1)) //the column value of the truth point is smaller than col
            {
                maxC = col-1;
                col = (minC +maxC)/2;
            }
        }
        arr[0] = row; //give value
        arr[1] = col; //give value
        return arr;
    }

    public static int[] ask (int x, int y)
    {
        int[] secretPoint = {5,5};
        int[] feedback = {0,0};
        if (x > secretPoint[0])
        {
            feedback[0] = 1;
        }
        if (x < secretPoint[0])
        {
            feedback[0] = -1;
        }
        if (y > secretPoint[0])
        {
            feedback[1] = 1;
        }
        if (y < secretPoint[0])
        {
            feedback[1] = -1;
        }
        return feedback;
    }

}
