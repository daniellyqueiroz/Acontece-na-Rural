

function initCalendar(eventsArray) {

    // page is now ready, initialize the calenda :r...
    $('#calendar').fullCalendar({
    	//contentHeight: 465;
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'listDay,listWeek,month'
        },
        views: {
            listDay: { buttonText: 'Dia' },
            listWeek: { buttonText: 'Semana' }
        },
        navLinks: true, // can click day/week names to navigate views
        events: eventsArray,
		contentHeight: 465,
        eventLimit: true
        // put your options and callbacks here
    });
}

function setLoginBg(){
	$('body').css({
		background: '#1b2d4f'  
	});
}

function setAdminBg(){
	$('body').css({
		background: '#f7f7f7' 
	});
}

function setSettings(){
    setTimeout (function (){
        var imgs = $('.panopoly-image-original');
        var a = $('.field-name-node-link a');
        if(a.attr('href').indexOf('http') == -1){
            a.attr('href', ('http://ufrpe.br'+a.attr('href')));
        };
        
        for (var i=0; i<imgs.length;  i++){
            $(imgs[i]).removeAttr ('width');
        $(imgs[i]).removeAttr('heigth');
            $(imgs[i]).css({
            'max-width': '100%',
            'height': 'auto'
            });
    }}, 250);

    
}

//http://ufrpe.br/br/rss.xml



