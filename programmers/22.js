//카펫
function solution(brown, yellow) {
    let brownNum = (brown + 4)/2;
    let yellowNum;
    let column = 3;
    for (let i = 3; i <= brownNum/2; i++ ) {
        yellowNum = (i - 2) * (brownNum - i - 2);
        if (yellowNum === yellow) {
            column = i;
        }
    }
    return [brownNum-column, column];
}