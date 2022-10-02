//거리두기 확인하기
function solution(places) {
    let answer = [];
    
    places.map((el, index) => {
        for (let j = 0; j < 5; j++) {
            for (let i = 0; i < 5; i++) {
                if (el[j][i] === "P") {
                    if (i+1<=4 && el[j][i+1] === "P") {
                        answer[index] = 0;
                        break;
                    } else if (i+2<=4 && el[j][i+2] === "P") {
                        if (i+1 <=4 && el[j][i + 1] !== "X") {
                            answer[index] = 0;
                            break;
                        }
                    } 

                    answer[index] =columnCheck(el, j, i, index);
                    if (answer[index] === 0) {
                        break;
                    } else {
                        continue;
                    }
                }
            }
            if (answer[index] === 0) {
                break;
            }
        }
    })
    
    
    function columnCheck(places, j, i, index) {
        if (j-1 >= 0 && places[j-1][i] === "P") {
            return 0;
        }
        if (j+1<=4 && places[j + 1][i + 1] === "P") {
            if (places[j + 1][i] !== "X" || places[j][i + 1] !== "X") {
                return 0;
            }
        }
        if (j+1<=4 && places[j + 1][i - 1] === "P") {
            if (places[j + 1][i] !== "X" || places[j][i - 1] !== "X") {
                return 0;
            }
        }

        if (j-2>=0 && places[j - 2][i] === "P") {
            if (places[j - 1][i] !== "X") {
                return 0;
            }
        }
       
        return 1;
    }
    
    for (let i = 0; i < 5; i++) {
        if (answer[i] === undefined) {
            answer[i] = 1;
        }
    }
    
    
    return answer;
}