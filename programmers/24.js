//거리두기 확인하기
function solution(places) {
    let answer = [];
    let distance;
    places.map((el) => {
        for (let j = 0; j < 5; j++) {
            // if (el[j].indexOf("P") === el[j].lastIndexOf("P")) {
                // answer.push(columnCheck(places, j, i));
                // break;
            // } else {
                for (let i = 0; i < 5; i++) {
                    distance = el[j].indexOf("P", i + 1) - el[j].indexOf("P", i);
                    if (distance === 1) {
                        answer.push(0);
                        break;
                    } else if (distance === 2) {
                        if (el[j][el[j].indexOf("P", i + 1) + 1] === "X") {
                            answer.push(0);
                            break;
                        }
                    } else {
                        answer.push(columnCheck(places, j, i));
                        break;
                    }
                }
                if (!answer[j]) {
                    break;
                }
            // }
        }
    })
    
    function rowCheck() {
        
    }
    
    function columnCheck(places, j, i) {
        if ((j+1 <= 4 && places[j+1][i] === "P") || (j-1 >= 0 && places[j-1][i] === "P") ) {
            return 0;
        } else if (j+1<=4 && places[j + 1][i + 1] === "P") {
            if (places[j + 1][i] !== "X" || places[j][i + 1] !== "X") {
                return 0;
            }
        } else if (j+1<=4 && places[j + 1][i - 1] === "P") {
            if (places[j + 1][i] !== "X" || places[j][i - 1] !== "X") {
                return 0;
            }
        } else if (j-1>=0 && places[j - 1][i + 1] === "P") {
            if (places[j - 1][i] !== "X" || places[j][i + 1] !== "X") {
                return 0;
            }
        } else if (j-1 >=0 && places[j - 1][i - 1] === "P") {
            if (places[j - 1][i] !== "X" || places[j][i - 1] !== "X") {
                return 0;
            }
        } else if (j-2>=0 && places[j - 2][i] === "P") {
            if (places[j - 1][i] !== "X") {
                return 0;
            }
        } else if (j+2<=4 && places[j + 2][i] === "P") {
            if (places[j + 1][i] !== "X") {
                return 0;
            }
        }
    }
    
    return answer;
}