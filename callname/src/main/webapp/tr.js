var timmer = null;
var no = 0;
var list_now = [];
var data = false;

window.onload = function() {
    timmer = setInterval('showList()',1000);
}

function showList(){
    // 请求数据
    getData();
    var panel_switch = true;
    if(data == false) return false;

    // 生成列表
    var info_list = getElementsByClass('info_list')[0];
    var info_item = info_list.children[2];
    var lis = info_list.getElementsByTagName('li');

    //删除旧的数据项
    if(lis[1]){
        for (var j = lis.length-1; j > 0; j--) {
            info_list.removeChild(lis[j]);
            no = no - 1;
        }
    }
    //根据新数据建立列表
    for (var i = 0; i < data.length; i++) {
        if(data[i].flag == 0){
            if(panel_switch){
                //隐藏提示面板
                var hint_panel = document.getElementById("hint_panel");
                hint_panel.style.display = "none";
                //显示列表
                var title = document.getElementById("title");
                var leftbar = document.getElementById("leftbar");
                var rightbar = document.getElementById("rightbar");
                title.style.display = "block";
                leftbar.style.display = "block";
                rightbar.style.display = "block";
                panel_switch = false;
            }
            list_now.push(data[i]);
            no = no + 1;
            add_item(info_list, info_item, data[i]);
        } else {
            if (list_now.some(function(item, index, array){
                return item.sno == data[i].sno && item.time == data[i].time;
            })) {
                no = no + 1;
                add_item(info_list, info_item, data[i]);
            }
        }

    }
}

function add_item(info_list, info_item, obj){
    var item = info_item.cloneNode(true);
    var spans = item.getElementsByTagName('span');
    spans[0].innerHTML = "0" + no;
    spans[1].innerHTML = "班级:" + obj.classNumber;
    spans[2].innerHTML = "性别:" + obj.sex;
    spans[3].innerHTML = "总分:" + obj.totalScore;
    spans[4].innerHTML = "抽查次数:" + obj.times;
    spans[5].innerHTML = "时间:" + obj.time;
    spans[6].innerHTML = obj.name;
    spans[7].innerHTML = obj.sno;
    if(obj.score > 0){
        spans[8].innerHTML = "+" + obj.score;
    } else if(obj.score == 0) {
        spans[8].innerHTML = "wait";
    } else {
        spans[8].innerHTML = obj.score;
    }
    info_list.appendChild(item);
}

function getData(){
    //发送请求
    var xhr = createXHR(),
        url = 'http://localhost:8080/callname/api/show/scorePage';
    xhr.open('post', url, true);
    xhr.send();
    xhr.onreadystatechange = function () {
        if(xhr.readyState == 4){
            if(xhr.status == 200){
                data = JSON.parse(xhr.responseText).obj;
            }
        }
    }
}

function createXHR() {
    var xhr;
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    return xhr;
}

function getElementsByClass(clsName,parent){
    var oParent=parent?parent:document,
        result=[],
        elements=oParent.getElementsByTagName('*');

    for(var i=0,l=elements.length;i<l;i++){
        if(elements[i].className==clsName){
            result.push(elements[i]);
        }
    }
    return result;
}
