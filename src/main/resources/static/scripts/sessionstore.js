sessionData = {
    isSessionStorage:window.sessionStorage?true:false,

    initDom:function(){
        return true;
    },
    set:function(key,value){
        if(this.isSessionStorage){
            window.sessionStorage.setItem(key,value);
        }
    },
    get:function(key){
        if(this.isSessionStorage){
            return window.sessionStorage.getItem(key);
        }
    },
    remove:function(key){
        if(this.isSessionStorage){
            sessionStorage.removeItem(key);
        }
    }
}
