#include "helpers.h"

// Convert image to grayscale
void grayscale(int height, int width, RGBTRIPLE image[height][width])
{
    for (int i=0;i<height;i++)
        for (int j=0;j<width;j++)
        {
            int sum=image[i][j].rgbtBlue+image[i][j].rgbtGreen+image[i][j].rgbtRed;
            image[i][j].rgbtBlue=image[i][j].rgbtGreen=image[i][j].rgbtRed=sum/3;
        }
    return;
}

// Reflect image horizontally
void reflect(int height, int width, RGBTRIPLE image[height][width])
{
    return;
}

// Blur image
void blur(int height, int width, RGBTRIPLE image[height][width])
{
    return;
}

// Detect edges
void edges(int height, int width, RGBTRIPLE image[height][width])
{
    return;
}
