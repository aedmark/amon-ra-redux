;;; Sierra Script 1.0 - (do not remove this comment)
(script# 14)
(include sci.sh)
(use Main)
(use n012)
(use Print)
(use RTRandCycle)
(use Obj)

(public
	lb2InitCode 0
)

(instance lb2InitCode of Code
	(properties
		sel_20 {lb2InitCode}
	)
	
	(method (sel_110 &tmp temp0)
		(= global16 1000)
		(= gSel_30 69)
		(= global26 2108)
		(= global23 1207)
		(= global118 2407)
		(= global119 4115)
		(= global120 2510)
		(Print sel_30: gSel_30)
		((= gNarrator Narrator)
			sel_30: gSel_30
			sel_26: 15
			sel_538: 1
		)
		(= global90 1)
		(= gLb2Win (ScriptID 0 9))
		(= temp0 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING global27 11 temp0)
		(FileIO fiREAD_STRING global112 20 temp0)
		(FileIO fiREAD_STRING global113 20 temp0)
		(FileIO fiREAD_STRING global114 20 temp0)
		(FileIO fiCLOSE temp0)
		(proc12_0)
		(= global34 1)
		(= gSel_188 30)
		(StrCpy @global42 {})
		(gGame sel_197: gSel_582 1 304 172 sel_321: 5)
		(= global94 2)
		(= global106 (DoSound sndGET_POLYPHONY))
		(if
			(and
				(>= (= global105 (Graph grGET_COLOURS)) 2)
				(<= global105 16)
			)
			(proc0_4 0)
		else
			(proc0_3 0)
		)
		(gLb2Win sel_25: 0 sel_26: global176)
		((ScriptID 15 1)
			sel_25: 0
			sel_26: global176
			sel_367: global176
			sel_368: global176
			sel_369: global176
			sel_370: global176
			sel_374: gSel_212
			sel_375: global172
			sel_376: global172
			sel_377: global173
			sel_378: global173
		)
		((ScriptID 21 0) sel_57: 257)
		((ScriptID 21 0) sel_57: 258)
		((ScriptID 21 0) sel_57: 259)
		((ScriptID 21 0) sel_57: 260)
		((ScriptID 21 0) sel_57: 261)
		((ScriptID 21 0) sel_57: 262)
		((ScriptID 21 0) sel_57: 273)
		((ScriptID 21 0) sel_57: 513)
		((ScriptID 21 0) sel_57: 514)
		((ScriptID 21 0) sel_57: 515)
		((ScriptID 21 0) sel_57: 516)
		((ScriptID 21 0) sel_57: 517)
		((ScriptID 21 0) sel_57: 518)
		((ScriptID 21 0) sel_57: 519)
		((ScriptID 21 0) sel_57: 771)
		((ScriptID 21 0) sel_57: 1026)
		((ScriptID 21 0) sel_57: 1027)
		((ScriptID 21 0) sel_57: 1028)
		(DisposeScript 21)
		(DisposeScript 12)
	)
)
