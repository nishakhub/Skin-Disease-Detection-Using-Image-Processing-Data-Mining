clc
clear all
close all


matlabroot='D:'
Datasetpath=fullfile(matlabroot,'cnn','Dataset')

Data=imageDatastore(Datasetpath,'IncludeSubfolders',true,'LabelSource','foldernames')

layers=[imageInputLayer([221 293 3])
    convolution2dLayer(11,50)
    reluLayer
    maxPooling2dLayer(4,'stride',4)
    convolution2dLayer(11,50)
    reluLayer
    maxPooling2dLayer(4,'stride',4)
    fullyConnectedLayer(4)
    softmaxLayer
    classificationLayer()]

options=trainingOptions('sgdm','MaxEpochs',15,'initialLearnRate',0.0001);


convnet=trainNetwork(Data,layers,options)


    