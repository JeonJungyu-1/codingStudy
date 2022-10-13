//신규 아이디 추천
function solution(new_id) {
    let compare = ['-', '_', '.']
    let regexpNumber = /\p{Nd}/u;
    let regexpString = /\p{Ll}/u
    new_id = new_id.toLowerCase();
    for (let i = 0; i < new_id.length; i++) {
        if (!regexpNumber.test(new_id[i]) && !regexpString.test(new_id[i]) && !compare.includes(new_id[i])) {

            new_id = new_id.replace(new_id[i], "");
            i--;
        }
    }
    new_id = new_id.replace(/\.+/g, ".")
    

    if (new_id[0] === ".") {
        new_id = new_id.slice(1);
    }
    
    
    if (new_id.length >= 16) {
        new_id = new_id.slice(0, 15);
    }
    
    if (new_id[new_id.length-1] === ".") {
        new_id = new_id.slice(0, new_id.length - 1);
    }
    
    if (!new_id) return "aaa";

    
    while (new_id.length <= 2) {
        new_id += new_id[new_id.length - 1];
    }
    
    return new_id;
}