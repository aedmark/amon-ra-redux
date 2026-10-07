;;; Sierra Script 1.0 - (do not remove this comment)
(script# 450)
(include sci.sh)
(use Main)
(use LBRoom)
(use ExitFeature)
(use MuseumRgn)
(use Scaler)
(use PolyPath)
(use CueObj)
(use MoveFwd)
(use n958)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm450 0
)

(local
	local0
)
(instance rm450 of LBRoom
	(properties
		sel_20 {rm450}
		sel_213 13
		sel_408 450
		sel_411 448
		sel_412 454
		sel_107 172
		sel_108 21
	)
	
	(method (sel_110)
		(proc958_0 128 454 423 452 858 424)
		(proc958_0 132 450 600)
		(proc958_0 130 2450)
		(gEgo
			sel_110:
			sel_585: (if (== global123 5) 426 else 831)
			sel_320: Scaler 131 30 190 21
		)
		(if (== global123 5)
			(self sel_414: 94)
			(global2 sel_259: (List sel_109:))
			((ScriptID 2450 0) sel_57: (global2 sel_259?))
		else
			(self sel_414: 90)
		)
		(switch gGSel_40
			(sel_412
				(gGame sel_588:)
				(= sel_28 12)
				(if
					(and
						(proc0_2 35)
						(== global123 3)
						(not (proc0_10 -24319 0))
					)
					((ScriptID 90 15) sel_137: 2)
				)
			)
			(sel_411
				(= sel_28 100)
				(gEgo sel_1: 160 sel_0: 350)
				(self sel_146: sComeOnIn)
				(if (and (== global123 5) (proc0_2 90))
					(self sel_403:)
				)
			)
			(else 
				(gGame sel_588:)
				(gEgo sel_1: 160 sel_0: 160)
			)
		)
		(super sel_110:)
		(if (and (!= gGSel_40 sel_412) (< global123 5))
			(if (== global123 2)
				(gSel_608 sel_168:)
			else
				(WrapMusic sel_168:)
			)
			(gGameMusic2 sel_40: 450 sel_99: 1 sel_3: -1 sel_39:)
		)
		(if (proc0_2 38)
			(shatteredGlass sel_110: sel_313: sel_311: 1 4 8)
		else
			(glass sel_110: sel_313: sel_311: 1 4 8)
		)
		(pyramid sel_110: sel_311: 1 4 8)
		(wallWindow sel_110: sel_311: 1 4 8)
		(daggerCase sel_110: sel_311: 1 4 8)
		(mummy sel_110: sel_311: 1 4 8)
		(post sel_110: sel_311: 1 4 8)
		(wings sel_110: sel_311: 1 4 8)
		(rock1 sel_110: sel_311: 1 4 8)
		(plaque sel_110: sel_311: 1 4 8)
		(rock2 sel_110: sel_311: 1 4 8)
		(westExitFeature sel_110:)
		(southExitFeature sel_110:)
	)
	
	(method (sel_57)
		(super sel_57:)
		(cond 
			(sel_142)
			((proc0_1 gEgo 16) (self sel_146: sEgoLeaveSouth))
		)
	)
	
	(method (sel_111)
		(DisposeScript 2450)
		(super sel_111: &rest)
	)
	
	(method (sel_399 param1)
		(cond 
			((and (== param1 sel_411) (== global123 2)) (gGameMusic2 sel_170: 1) (gSel_608 sel_168: 0))
			((and (== param1 sel_411) (< global123 5)) (gGameMusic2 sel_170: 1) (WrapMusic sel_168: 0))
		)
		(super sel_399: param1)
	)
	
	(method (sel_403)
		(cond 
			((gEgo sel_142?)
				((gEgo sel_142?)
					sel_65: (if (== global123 5) sDie else sLauraTutMeeting)
				)
			)
			((global2 sel_142?)
				((global2 sel_142?)
					sel_65: (if (== global123 5) sDie else sLauraTutMeeting)
				)
			)
			(else
				(global2
					sel_146: (if (== global123 5) sDie else sLauraTutMeeting)
				)
			)
		)
	)
)

(instance sComeOnIn of Script
	(properties
		sel_20 {sComeOnIn}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_153: 160 300)
				(gEgo sel_312: MoveTo 160 160 self)
			)
			(2
				(if
					(and
						(proc0_2 35)
						(== global123 3)
						(not (proc0_10 -24319 0))
					)
					((ScriptID 90 15) sel_137: 2)
				)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sEgoLeaveSouth of Script
	(properties
		sel_20 {sEgoLeaveSouth}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_55: 180)
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: MoveFwd 75 self)
			)
			(2 (global2 sel_399: 448))
		)
	)
)

(instance sLauraTutMeeting of Script
	(properties
		sel_20 {sLauraTutMeeting}
	)
	
	(method (sel_57)
		(super sel_57:)
		(if (and (== sel_29 0) (not (global2 sel_365:)))
			(self sel_145:)
		)
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (gGame sel_587:))
			(1
				(if (== ((ScriptID 90 4) sel_620?) 450)
					((ScriptID 90 4) sel_619: 0 sel_146: 0)
				else
					((ScriptID 90 4)
						sel_182: 450
						sel_2: 821
						sel_1: 190
						sel_0: 270
					)
				)
				(= sel_136 2)
			)
			(2
				((ScriptID 90 4) sel_312: PolyPath 190 160 self)
			)
			(3
				(gEgo sel_312: PolyPath 160 160 self)
			)
			(4
				(proc0_5 gEgo (ScriptID 90 4))
				(proc0_5 (ScriptID 90 4) gEgo)
				(= sel_136 4)
			)
			(5 (= sel_136 1))
			(6
				(gLb2Messager sel_295: 1 0 1 0 self 1450)
			)
			(7
				((ScriptID 90 4)
					sel_664:
						(if (!= ((ScriptID 90 4) sel_652?) 450)
							((ScriptID 90 4) sel_652?)
						else
							454
						)
						(ScriptID 90 4)
				)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sDie of Script
	(properties
		sel_20 {sDie}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 160 160 self)
			)
			(1
				(oriley
					sel_110:
					sel_320: Scaler 131 30 190 21
					sel_161: Walk
					sel_312: PolyPath 190 170 self
				)
				(gSel_608 sel_40: 3 sel_99: 1 sel_3: 1 sel_39:)
			)
			(2
				(oriley sel_2: 424)
				(oriley sel_4: 0)
				(proc0_5 gEgo oriley)
				(proc0_5 oriley gEgo)
				(= sel_136 4)
			)
			(3 (oriley sel_161: End self))
			(4
				(thudSound sel_39:)
				(gEgo sel_2: 858 sel_161: End self)
			)
			(5
				(= global145 0)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sBreakIt of Script
	(properties
		sel_20 {sBreakIt}
	)
	
	(method (sel_57)
		(super sel_57:)
		(if (and (not local0) (== (glass sel_4?) 5))
			(nGlass sel_39:)
			(= local0 1)
		)
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_2: 452 sel_3: 2 sel_4: 0 sel_161: CT 2 1 self)
			)
			(1
				(gEgo sel_161: End self)
				(glass sel_161: End self)
			)
			(2 0)
			(3
				(gLb2Messager sel_295: 4 4 1 0 self)
			)
			(4
				(glass sel_111:)
				(shatteredGlass sel_110: sel_313: sel_311: 1 4 8)
				(proc0_3 38)
				(gEgo sel_585: (if (== global123 5) 426 else 831))
				(gEgo sel_3: 5)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance oriley of Actor
	(properties
		sel_20 {oriley}
		sel_1 200
		sel_0 240
		sel_2 423
	)
)

(instance glass of Prop
	(properties
		sel_20 {glass}
		sel_1 17
		sel_0 161
		sel_303 58
		sel_304 164
		sel_2 452
		sel_3 1
		sel_60 12
		sel_14 16400
	)
	
	(method (sel_300 param1)
		(asm
			lsp      param1
			dup     
			ldi      1
			eq?     
			bnt      code_0807
			pushi    295
			pushi    3
			pushi    4
			pushi    1
			pushi    1
			pushi    38
			callb    proc0_2,  2
			bnt      code_07ff
			ldi      2
code_07ff:
			push    
			lag      gLb2Messager
			send     10
			jmp      code_0887
code_0807:
			dup     
			ldi      4
			eq?     
			bnt      code_0851
			pushi    1
			pushi    38
			callb    proc0_2,  2
			bnt      code_0826
			pushi    #sel_295
			pushi    3
			pushi    4
			dup     
			pushi    2
			lag      gLb2Messager
			send     10
			jmp      code_0887
code_0826:
			pushi    #sel_142
			pushi    0
			lag      global2
			send     4
			not     
			bnt      code_0887
			pushi    #sel_646
			pushi    0
			class    MuseumRgn
			send     4
			bnt      code_084b
			pushi    #sel_146
			pushi    1
			lofsa    sBreakIt
			push    
			lag      global2
			send     6
			jmp      code_0887
code_084b:
			ldi      1
			ret     
			jmp      code_0887
code_0851:
			dup     
			ldi      8
			eq?     
			bnt      code_087f
			pushi    1
			pushi    38
			callb    proc0_2,  2
			bnt      code_086f
			pushi    #sel_295
			pushi    3
			pushi    4
			pushi    8
			pushi    2
			lag      gLb2Messager
			send     10
			jmp      code_0887
code_086f:
			pushi    #sel_295
			pushi    3
			pushi    4
			pushi    8
			pushi    1
			lag      gLb2Messager
			send     10
			jmp      code_0887
code_087f:
			class    1358
			pToa     --UNKNOWN-PROP-NAME--
			lap      param1
code_0887:
			toss    
			ret     
		)
	)
)

(instance shatteredGlass of View
	(properties
		sel_20 {shatteredGlass}
		sel_1 17
		sel_0 161
		sel_213 9
		sel_2 454
		sel_14 16384
	)
)

(instance plaque of Feature
	(properties
		sel_20 {plaque}
		sel_1 290
		sel_0 78
		sel_213 12
		sel_6 69
		sel_7 286
		sel_8 87
		sel_9 295
		sel_301 40
		sel_303 277
		sel_304 142
	)
)

(instance pyramid of Feature
	(properties
		sel_20 {pyramid}
		sel_1 69
		sel_0 142
		sel_213 5
		sel_301 40
		sel_302 64
		sel_303 78
		sel_304 150
	)
)

(instance daggerCase of Feature
	(properties
		sel_20 {daggerCase}
		sel_1 33
		sel_0 168
		sel_213 4
		sel_6 142
		sel_7 18
		sel_8 167
		sel_9 48
		sel_301 40
		sel_303 58
		sel_304 164
	)
	
	(method (sel_300 param1)
		(asm
			lsp      param1
			dup     
			ldi      1
			eq?     
			bnt      code_08ab
			pushi    295
			pushi    3
			pushi    4
			pushi    1
			pushi    1
			pushi    38
			callb    proc0_2,  2
			bnt      code_08a3
			ldi      2
code_08a3:
			push    
			lag      gLb2Messager
			send     10
			jmp      code_092c
code_08ab:
			dup     
			ldi      4
			eq?     
			bnt      code_08f5
			pushi    1
			pushi    38
			callb    proc0_2,  2
			bnt      code_08ca
			pushi    #sel_295
			pushi    3
			pushi    4
			dup     
			pushi    2
			lag      gLb2Messager
			send     10
			jmp      code_092c
code_08ca:
			pushi    #sel_142
			pushi    0
			lag      global2
			send     4
			not     
			bnt      code_092c
			pushi    #sel_646
			pushi    0
			class    MuseumRgn
			send     4
			bnt      code_08ef
			pushi    #sel_146
			pushi    1
			lofsa    sBreakIt
			push    
			lag      global2
			send     6
			jmp      code_092c
code_08ef:
			ldi      1
			ret     
			jmp      code_092c
code_08f5:
			dup     
			ldi      8
			eq?     
			bnt      code_0924
			pushi    1
			pushi    38
			callb    proc0_2,  2
			bnt      code_0914
			pushi    #sel_295
			pushi    3
			pushi    4
			pushi    8
			pushi    2
			lag      gLb2Messager
			send     10
			jmp      code_092c
code_0914:
			pushi    #sel_295
			pushi    3
			pushi    4
			pushi    8
			pushi    1
			lag      gLb2Messager
			send     10
			jmp      code_092c
code_0924:
			class    1358
			pToa     --UNKNOWN-PROP-NAME--
			lap      param1
code_092c:
			toss    
			ret     
		)
	)
)

(instance post of Feature
	(properties
		sel_20 {post}
		sel_1 219
		sel_0 148
		sel_213 2
		sel_6 25
		sel_7 206
		sel_8 146
		sel_9 232
		sel_301 40
		sel_303 213
		sel_304 155
	)
)

(instance mummy of Feature
	(properties
		sel_20 {mummy}
		sel_1 120
		sel_0 176
		sel_213 1
		sel_6 97
		sel_7 105
		sel_8 176
		sel_9 136
		sel_301 40
		sel_303 164
		sel_304 172
	)
)

(instance wallWindow of Feature
	(properties
		sel_20 {wallWindow}
		sel_1 177
		sel_0 80
		sel_213 3
		sel_6 58
		sel_7 158
		sel_8 102
		sel_9 197
		sel_301 40
		sel_303 179
		sel_304 123
	)
)

(instance wings of Feature
	(properties
		sel_20 {wings}
		sel_1 176
		sel_0 45
		sel_213 6
		sel_6 36
		sel_7 147
		sel_8 54
		sel_9 205
		sel_301 40
		sel_303 180
		sel_304 122
	)
)

(instance rock1 of Feature
	(properties
		sel_20 {rock1}
		sel_1 76
		sel_0 76
		sel_213 8
		sel_6 42
		sel_7 22
		sel_8 110
		sel_9 130
		sel_301 40
		sel_303 19
		sel_304 125
	)
)

(instance rock2 of Feature
	(properties
		sel_20 {rock2}
		sel_1 251
		sel_0 79
		sel_213 7
		sel_6 42
		sel_7 232
		sel_8 116
		sel_9 270
		sel_301 40
		sel_303 251
		sel_304 130
	)
)

(instance westExitFeature of ExitFeature
	(properties
		sel_20 {westExitFeature}
		sel_6 120
		sel_8 169
		sel_9 5
		sel_33 12
		sel_583 4
		sel_213 11
	)
)

(instance southExitFeature of ExitFeature
	(properties
		sel_20 {southExitFeature}
		sel_6 184
		sel_8 189
		sel_9 320
		sel_33 11
		sel_583 3
		sel_213 10
	)
)

(instance nGlass of Sound
	(properties
		sel_20 {nGlass}
		sel_99 5
		sel_40 600
	)
)

(instance thudSound of Sound
	(properties
		sel_20 {thudSound}
		sel_99 5
		sel_40 80
	)
)
