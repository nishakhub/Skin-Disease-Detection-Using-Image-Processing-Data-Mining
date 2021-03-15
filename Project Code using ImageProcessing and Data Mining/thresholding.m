function [L]=thresholding(K);
thresh = multithresh(K,2);
seg_I = imquantize(K,thresh);
RGB = label2rgb(seg_I); 	 
L=RGB;