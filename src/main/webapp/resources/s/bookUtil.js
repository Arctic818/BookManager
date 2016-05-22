function _BookUtil(){
    this.deleteBook = function(id) {
        if (confirm("Are you sure?")){
            window.location = "/deleteBook/" + id;
        }
        
    }
}

function _BookUtil2(){
    this.editBook = function(id) {
        if (confirm("Are you sure?")){
            window.location = "/editBook/" + id;
        }

    }
}

var BookUtil = new _BookUtil();
var BookUtil2 = new _BookUtil2();
