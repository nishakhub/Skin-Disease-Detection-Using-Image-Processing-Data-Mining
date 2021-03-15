function [K]=MedianFilter(im);
%%noisy = imnoise(im,'salt & pepper',0.1);
%%[m,n]=size(noisy);
%%output=zeros(m,n);
%%output=uint8(output);
%%for i = 1:m
   %% for j = 1:n
      %%  xmin = max(1,i-1);
      %%  xmax = min(m,i+1);
      %%  ymin = max(1,j-1);
       %% ymax = min(n,j+1);
       %% temp = noisy(xmin:xmax , ymin:ymax);
      %%  output(i,j)=median(temp(:));
 %%   end
%%end
%%K=output;
J = imnoise(im,'salt & pepper',0.02);
K = medfilt2(J);

