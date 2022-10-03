//2개 이하로 다른 비트
function solution(numbers) {
    let answer = [];
    let binary;
    for (let i = 0; i < numbers.length; i++) {
        binary = numbers[i].toString(2);
        for (let j = binary.length - 1; j >= 0; j--) {
            if (binary[binary.length - 1] === "0") {
                answer.push(parseInt(binary.slice(0, binary.length - 1) + "1" , 2));
                break;
            }
            
            if (binary[j] === "1") {
                if (j === 0) {
                    answer.push(parseInt("10" + binary.slice(j + 1) ,2))
                    break;
                } else {
                    if (binary[j - 1] === "0") {
                        answer.push(parseInt(binary.slice(0, j - 1) + "10" + binary.slice(j + 1), 2));
                        break;
                    }
                }
            }
        }
    }
    return answer;
}

