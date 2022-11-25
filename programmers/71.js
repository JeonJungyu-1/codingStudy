//뉴스 클러스터링
function solution(str1, str2) {
    let answer = 0;
    const regexp = /[a-z]/;
    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();
    if (str1 === str2) return 65536;
    const str1Arr = [];
    const str2Arr = [];
    const intersection = [];
    for (let i = 0; i < str1.length - 1; i++) {
        if (regexp.test(str1[i]) && regexp.test(str1[i + 1])) {
            str1Arr.push(str1.slice(i, i + 2));   
        }
    }
    for (let i = 0; i < str2.length - 1; i++) {
        if (regexp.test(str2[i]) && regexp.test(str2[i + 1])) {
            str2Arr.push(str2.slice(i, i + 2));   
        }
    }
    
    let str1Length = str1Arr.length;
    let str2Length = str2Arr.length;
    //교집합 구하기
    for (let i = 0; i < str1Arr.length; i++) {
        if (str2Arr.includes(str1Arr[i])) {
            intersection.push(str1Arr[i]);
            delete str2Arr[str2Arr.indexOf(str1Arr[i])];
        }
    }
    answer = Math.floor(intersection.length / (str1Length + str2Length - intersection.length) * 65536);
    return answer;
}