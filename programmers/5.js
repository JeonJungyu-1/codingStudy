//모의고사
function solution(answers) {
    //수포자1
    var one = [1, 2, 3, 4, 5];
    var jOne = 0;
    var correctOne = 0;
    for(var i = 0; i < answers.length; i++) {
        if (jOne == one.length) {
            jOne = 0;
            i--;
        }
        else {
            if (answers[i] == one[jOne]) {
                correctOne++;
            }
            jOne++;
        }
    }

    //수포자2
    var two = [2, 1, 2, 3, 2, 4, 2, 5];
    var jTwo = 0;
    var correctTwo = 0;
    for(var i = 0; i < answers.length; i++) {
        if (jTwo == two.length) {
            jTwo = 0;
            i--;
        }
        else {
            if (answers[i] == two[jTwo]) {
                correctTwo++;
            }
            jTwo++;
        }
    }

    //수포자3
    var three = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
    var jThree = 0;
    var correctThree = 0;
    for(var i = 0; i < answers.length; i++) {
        if (jThree == three.length) {
            jThree = 0;
            i--;
        }
        else {
            if (answers[i] == three[jThree]) {
                correctThree++;
            }   
            jThree++;
        }
    }

    var answer = [correctOne, correctTwo, correctThree];
    
    if (answer[0] > answer[1]) {
        if (answer[0] > answer[2]) {
            return [1];
        }
        else if (answer[0] == answer[2]) {
            return [1,3];
        }
        else {
            return [3];
        }
    }
    else if (answer[0] == answer[1]) {
        if (answer[0] > answer[2]) {
            return [1,2];
        }
        else if (answer[0] == answer[2]) {
            return [1,2,3];
        }
        else {
            return [3];
        }
    }
    else {
        if (answer[1] > answer[2]) {
            return [2];
        }
        else if (answer[1] == answer[2]) {
            return [2,3];
        }
        else {
            return [3];
        }
    }
    
}