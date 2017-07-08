var timmer = null;
var no = 0;
var list_now = [];
var flag = false;  //test

window.onload = function() {
    timmer = setInterval('showList()',1000);
}

function showList(){
    // 请求数据
    var data = getData();
    var panel_switch = true;
    if(data == false) return false;

    // 生成列表
    var info_list = getElementsByClass('info_list')[0];
    var info_item = info_list.children[0];
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
                //显示表头
                info_item.style.display = "block";
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

function add_item(info_list, info_item, data){
    var item = info_item.cloneNode(true);
    var tds = item.getElementsByTagName('tr')[0].children;
    tds[0].innerHTML = no;
    tds[1].innerHTML = data.sno;
    tds[2].innerHTML = data.name;
    tds[3].innerHTML = data.classNumber;
    tds[4].innerHTML = data.sex;
    tds[5].innerHTML = data.times;
    tds[6].innerHTML = data.totalScore;
    tds[7].innerHTML = data.score;
    tds[8].innerHTML = data.time;
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
                 var data = JSON.parse(xhr.responseText).obj;
                 return data;
            }
         }
     }
     return false;
    /*
    if(!flag){
        return [
            {
                "sno" : "2133",
                "name" : "我在啊",
                "classNumber" : "031",
                "totalScore" : "623",
                "sex" : "female",
                "times" : "5",
                "time" : "2017-06-28 14:47:27.0",
                "score" : "1",
                "flag" : "0"
            },
            {
                "sno" : "666",
                "name" : "不在吧",
                "classNumber" : "03",
                "totalScore" : "75",
                "sex" : "male",
                "times" : "1",
                "time" : "2017-06-28 15:44:17.0",
                "score" : "2",
                "flag" : "0"
            }
        ]
    }
    return [
        {
            "sno" : "0051",
            "name" : "我是谁啊",
            "classNumber" : "012",
            "totalScore" : "132",
            "sex" : "female",
            "times" : "21",
            "time" : "2017-06-28 5:47:27.0",
            "score" : "1",
            "flag" : "0"
        },
        {
            "sno" : "006",
            "name" : "我在哪",
            "classNumber" : "03",
            "totalScore" : "65",
            "sex" : "male",
            "times" : "4",
            "time" : "2017-06-30 22:47:27.0",
            "score" : "1",
            "flag" : "0"
        },
        {
            "sno" : "666",
            "name" : "不在吧",
            "classNumber" : "03",
            "totalScore" : "751",
            "sex" : "male",
            "times" : "1",
            "time" : "2017-06-28 15:44:17.0",
            "score" : "20",
            "flag" : "1"
        },
        {
            "sno" : "2133",
            "name" : "我在啊",
            "classNumber" : "031",
            "totalScore" : "623",
            "sex" : "female",
            "times" : "5",
            "time" : "2017-06-28 14:47:27.0",
            "score" : "1",
            "flag" : "0"
        }
    ]
	*/
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
