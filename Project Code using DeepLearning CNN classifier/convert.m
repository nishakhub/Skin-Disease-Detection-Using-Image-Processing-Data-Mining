% CNN TESTING CONFUSION MATRIX
targetsVector = [1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,3,3,3,4,3,3,4]; % True classes
outputsVector = [1,1,2,2,2,3,2,2,2,2,2,2,2,2,2,2,4,3,3,3,3,3,3,3,3,2,4,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,3,4,4,4,4,4,4,4,4,4,3,3,3,4,3,3,4]; % Predicted classes
% Convert this data to a [numClasses x 6] matrix
targets = zeros(4,61);
outputs = zeros(4,61);
targetsIdx = sub2ind(size(targets), targetsVector, 1:61);
outputsIdx = sub2ind(size(outputs), outputsVector, 1:61);
targets(targetsIdx) = 1;
outputs(outputsIdx) = 1;
% Plot the confusion matrix for a 3-class problem
plotconfusion(targets,outputs)