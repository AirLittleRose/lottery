!function(r,n,e,t,i){t.ssq=t.ssq||{};t.ssq.clientRandom=function(r){var n=[],e=0,i;for(;e<+r;e++){i=[f(),t.random("1-16",1)];i.random=1;n[e]=i}return n};e.stopRedFilter=false;var f=function(r){var i=t.random("1-33",6);if(e.stopRedFilter||"yes"==n.getPara("r"))return i;if(i[0]>17||i[5]<17)return f();if(i[5]-i[0]==5||i[4]-i[0]==4||i[5]-i[1]==4)return f();if(i[5]<10||i[0]>9&&i[5]<20||i[0]>19&&i[5]<30)return f();var u=[0,0,0],a=[0,0],s=[0,0];n.each(i,function(r,n){u[n%3]++;a[n%2]++;if(n>1)s[o(n)]++});if(u[0]>4||u[1]>4||u[2]>4||6==a[0]||6==a[1]||6==s[0]||6==s[1])return f();return i},o=function(r){var n=2;for(;n<r;n++)if(r%n==0)return 1;return 0}}(window,jQuery,Core,Game);