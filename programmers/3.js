//최소 직사각형
function solution(sizes) {
    let answer = 0;
    let length = [0, 0];
    sizes.map((el) => {
        if (el[0] > el[1]) {
            if (el[0] > length[0]) {
                length[0] = el[0];
            }
            if (el[1] > length[1]) {
                length[1] = el[1];
            }
        } else {
            if (el[1] > length[0]) {
                length[0] = el[1];
            }
            if (el[0] > length[1]) {
                length[1] = el[0];
            }
        }
    });
    answer = length[0] * length[1];
    return answer;
}