;;; Sierra Script 1.0 - (do not remove this comment)
(script# 99)
(include sci.sh)
(use Main)
(use LBRoom)
(use Print)

(public
	deathRoom 0
)

(instance deathRoom of LBRoom
	(properties
		sel_20 {deathRoom}
		sel_408 780
		sel_340 120
		sel_409 350
	)
	
	(method (sel_110 &tmp temp0 temp1)
		(asm
			pushi    #sel_110
			pushi    0
			super    LBRoom,  4
			pushi    #sel_40
			pushi    1
			pushi    99
			dup     
			pushi    1
			pushi    1
			pushi    3
			pushi    1
			pushi    1
			pushi    39
			pushi    0
			lag      gSel_608
			send     22
			lsg      global145
			ldi      15
			eq?     
			bnt      code_0038
			ldi      86
			sat      temp1
			jmp      code_003c
code_0038:
			ldi      62
			sat      temp1
code_003c:
			lsg      global145
			ldi      1
			add     
			sat      temp0
			pushi    2
			pushi    #sel_24
			pushi    0
			lag      gSel_561
			send     4
			push    
			pushi    0
			callk    Animate,  4
code_0050:
			pushi    #sel_198
			pushi    6
			pushi    1
			pushi    45
			lst      temp0
			pushi    0
			pushi    100
			pushi    0
			pushi    206
			pushi    5
			pushi    99
			pushi    0
			lsg      global145
			pushi    0
			pushi    0
			pushi    205
			pushi    4
			pushi    1
			lofsa    {Restore}
			push    
			pushi    0
			lst      temp1
			pushi    205
			pushi    4
			pushi    2
			lofsa    {Restart}
			push    
			pushi    70
			lst      temp1
			pushi    205
			pushi    4
			pushi    3
			lofsa    {____Quit____}
			push    
			pushi    140
			lst      temp1
			pushi    110
			pushi    0
			class    Print
			send     70
			push    
			dup     
			ldi      1
			eq?     
			bnt      code_00ac
			pushi    #sel_76
			pushi    0
			lag      gGame
			send     4
			jmp      code_00c7
code_00ac:
			dup     
			ldi      2
			eq?     
			bnt      code_00bb
			pushi    #sel_101
			pushi    0
			lag      gGame
			send     4
			jmp      code_00c7
code_00bb:
			dup     
			ldi      3
			eq?     
			bnt      code_00c7
			ldi      1
			sag      global4
			jmp      code_00ca
code_00c7:
			toss    
			jmp      code_0050
code_00ca:
			ret     
		)
	)
)
