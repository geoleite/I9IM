function setOp(operacao) {
    var f = document.forms[0];
    var c = f.elements['op'];
    c.value = operacao;
    f.submit();
}

function setOpForm(formname, operacao) {
    var f = document.forms[formname];
    var c = f.elements['op'];
    c.value = operacao;
    f.submit();
}

function setOpPortal(formname, operacao, page) {
    //alert(formname + ' ' + operacao + ' ' + page );
    var f = document.forms[formname];
    var c = f.elements['op'];
    c.value = operacao;
    //alert(c.value);
    var p = f.elements['urlCanal'];
    p.value=page;
    //alert(p.value);
    f.submit();
}

function setfocus() {
    var campos = document.forms[0].elements;
    for (var i=0; i < campos.length; i++) {
        if (campos[i].type != "hidden" && campos[i].type != "button" && 
            campos[i].type != "reset" && campos[i].type != "submit") {

            campos[i].focus();
            return;
        }
    }
    return;
}
  
/**
 * Define o foco para o proximo campo do formulário
 */
function nextField(fieldActual, e) {
    if (e && e.keyCode == 13) {
        var f = document.forms[0];
        var fields = f.elements;
        for(i=0; i < fields.length; i++) {
            if (fields[i]  == fieldActual) {
                fields[i+1].focus();
                return;
            }
        }
    }
}
function enter(e) {
    if (e && e.keyCode == 13)
        document.forms[0].submit();
}

function enterOpPortal(e, formname, operacao, page) {
    if (e && e.keyCode == 13) {
        setOpPortal(formname, operacao, page);
    }
}

function formata(val)
{
    var pass = val.value;
    var expr = /[0123456789]/;
		
    for(i=0; i<pass.length; i++){
        // charAt -> retorna o caractere posicionado no índice especificado
        var lchar = val.value.charAt(i);
        var nchar = val.value.charAt(i+1);
	
        if(i==0){
            // search -> retorna um valor inteiro, indicando a posição do inicio da primeira
            // ocorrência de expReg dentro de instStr. Se nenhuma ocorrencia for encontrada o método retornara -1
            // instStr.search(expReg);
            if ((lchar.search(expr) != 0) || (lchar>3)){
                val.value = "";
            }
		   
        }else if(i==1){
			   
            if(lchar.search(expr) != 0){
                // substring(indice1,indice2)
                // indice1, indice2 -> será usado para delimitar a string
                var tst1 = val.value.substring(0,(i));
                val.value = tst1;				
                continue;			
            }
			   
            if ((nchar != '/') && (nchar != '')){
                var tst1 = val.value.substring(0, (i)+1);
				
                if(nchar.search(expr) != 0) 
                    var tst2 = val.value.substring(i+2, pass.length);
                else
                    var tst2 = val.value.substring(i+1, pass.length);
	
                val.value = tst1 + '/' + tst2;
            }

        }else if(i==4){
			
            if(lchar.search(expr) != 0){
                var tst1 = val.value.substring(0, (i));
                val.value = tst1;
                continue;			
            }
		
            if	((nchar != '/') && (nchar != '')){
                var tst1 = val.value.substring(0, (i)+1);

                if(nchar.search(expr) != 0) 
                    var tst2 = val.value.substring(i+2, pass.length);
                else
                    var tst2 = val.value.substring(i+1, pass.length);
	
                val.value = tst1 + '/' + tst2;
            }
        }
		
        if(i>=6){
            if(lchar.search(expr) != 0) {
                var tst1 = val.value.substring(0, (i));
                val.value = tst1;			
            }
        }
    }
	
    if(pass.length>10)
        val.value = val.value.substring(0, 10);
    return true;
}

function mascara(o,f){
    
    v_obj=o
    v_fun=f
    setTimeout("execmascara()",1)
}

function execmascara(){
    
    v_obj.value=v_fun(v_obj.value)
}

function soNumeros(v){    
    return v.replace(/\D/g,"")
}

function soNumerosReais(v){
    // George Leite
    var digits="0123456789.,";
    var result="";
    for (var i=0; i < v.length; i++)  {
        var campo = v.substring(i, i+1);
        if (digits.indexOf(campo)>-1){
            result += campo;//v.substring(0,i);
        }
    }
    
    return result.replace(',', '.');
//return v.replace(/\D/g,"")
}

function telefone(v){
    v=v.replace(/\D/g,"")                 //Remove tudo o que não é dígito
    v=v.replace(/^(\d\d)(\d)/g,"($1) $2") //Coloca parênteses em volta dos dois primeiros dígitos
    v=v.replace(/(\d{4})(\d)/,"$1-$2")    //Coloca hífen entre o quarto e o quinto dígitos
    return v
}

function cpf(v){
    v=v.replace(/\D/g,"")                    //Remove tudo o que não é dígito
    v=v.replace(/(\d{3})(\d)/,"$1.$2")       //Coloca um ponto entre o terceiro e o quarto dígitos
    v=v.replace(/(\d{3})(\d)/,"$1.$2")       //Coloca um ponto entre o terceiro e o quarto dígitos
    //de novo (para o segundo bloco de números)
    v=v.replace(/(\d{3})(\d{1,2})$/,"$1-$2") //Coloca um hífen entre o terceiro e o quarto dígitos
    return v
}

function cep(v){
    v=v.replace(/D/g,"")                //Remove tudo o que não é dígito
    v=v.replace(/^(\d{5})(\d)/,"$1-$2") //Esse é tão fácil que não merece explicações
    return v
}

function cnpj(v){
    v=v.replace(/\D/g,"")                           //Remove tudo o que não é dígito
    v=v.replace(/^(\d{2})(\d)/,"$1.$2")             //Coloca ponto entre o segundo e o terceiro dígitos
    v=v.replace(/^(\d{2})\.(\d{3})(\d)/,"$1.$2.$3") //Coloca ponto entre o quinto e o sexto dígitos
    v=v.replace(/\.(\d{3})(\d)/,".$1/$2")           //Coloca uma barra entre o oitavo e o nono dígitos
    v=v.replace(/(\d{4})(\d)/,"$1-$2")              //Coloca um hífen depois do bloco de quatro dígitos
    return v
}

function romanos(v){
    v=v.toUpperCase()             //Maiúsculas
    v=v.replace(/[^IVXLCDM]/g,"") //Remove tudo o que não for I, V, X, L, C, D ou M
    //Essa é complicada! Copiei daqui: http://www.diveintopython.org/refactoring/refactoring.html
    while(v.replace(/^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$/,"")!="")
        v=v.replace(/.$/,"")
    return v
}

function site(v){
    //Esse sem comentarios para que você entenda sozinho ;-)
    v=v.replace(/^http:\/\/?/,"")
    dominio=v
    caminho=""
    if(v.indexOf("/")>-1)
        dominio=v.split("/")[0]
    caminho=v.replace(/[^\/]*/,"")
    dominio=dominio.replace(/[^\w\.\+-:@]/g,"")
    caminho=caminho.replace(/[^\w\d\+-@:\?&=%\(\)\.]/g,"")
    caminho=caminho.replace(/([\?&])=/,"$1")
    if(caminho!="")dominio=dominio.replace(/\.+$/,"")
    v="http://"+dominio+caminho
    return v
}

function visibleLayer(idLayer, estado) {
    showHideLayers(idLayer,'',estado?'show':'hide');

}

function findObject(n, d) { //v4.01
    var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
        d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);
    }
    if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
    for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=findObject(n,d.layers[i].document);
    if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function showHideLayers() { //v6.0
    var i,p,v,obj,args=showHideLayers.arguments;
    for (i=0; i<(args.length-2); i+=3) if ((obj=findObject(args[i]))!=null) {
        v=args[i+2];
        if (obj.style) {
            obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v;
        }
        obj.visibility=v;
    }
}
function enableDisableField(campo, stado) {
    var f = document.forms[0];
    var c =f.elements[campo];
    c.disabled =  stado;
}