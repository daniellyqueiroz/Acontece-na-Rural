

function initCalendar() {

    // page is now ready, initialize the calenda :r...
    $('#calendar').fullCalendar({
    	//contentHeight: 465;
    	events:[
    	{
            title: 'entrega da frequencia \nmonitoria na PREG',
            start: '2017-07-21',
            days: '2'
        },
        {
            title: 'REALIZAÇÃO DA \n2ª VA',
            start: '2017-07-24'
        },
        {
            title: 'evento 1',
            start: '2017-07-1'
        },
        {
            title: 'evento 2',
            start: '2017-07-4'
        },
        {
            title: 'evento 3',
            start: '2017-07-10'
        },
        {
            title: 'evento 4',
            start: '2017-07-30'
        },
        {
            title: 'evento 5',
            start: '2017-07-16'
        },
        {
            title: 'evento 6' ,
            start: '2017-07-19'
            
        },
        {
            title: 'teste' ,
            start: '2017-07-18'
            
        }

    	],
		contentHeight: 465
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

//http://ufrpe.br/br/rss.xml



