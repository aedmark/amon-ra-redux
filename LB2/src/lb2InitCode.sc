;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use n012)
(use Print)
(use Talker)
(use System)

(public
	lb2InitCode 0
)

(instance lb2InitCode of Code
	(properties
		sel_20 {lb2InitCode}
	)

	(method (sel_110 &tmp temp0)
		(= gPossibleScore 1000)
		(= gUserFont 69)
		(= gBigFont 2108)
		(= gSmallFont 1207)
		(= global118 2407)
		(= global119 4115)
		(= global120 2510)
		(Print sel_30: gUserFont)
		((= gNarrator Narrator) sel_30: gUserFont sel_26: 15 sel_538: 1)
		(= gMsgType 1)
		(= gSystemWindow (ScriptID 0 9)) ; lb2Win
		(= temp0 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 11 temp0)
		(FileIO fiREAD_STRING global112 20 temp0)
		(FileIO fiREAD_STRING global113 20 temp0)
		(FileIO fiREAD_STRING global114 20 temp0)
		(FileIO fiCLOSE temp0)
		(proc12_0)
		(= gUseSortedFeatures 1)
		(= gEatMice 30)
		(StrCpy @gSysLogPath {})
		(gGame sel_197: gTheCursor 1 304 172 sel_321: 5)
		(= gTextSpeed 2)
		(= global106 (DoSound sndGET_POLYPHONY))
		(if (and (>= (= global105 (Graph grGET_COLOURS)) 2) (<= global105 16))
			(ClearFlag 0)
		else
			(SetFlag 0)
		)
		(gSystemWindow sel_25: 0 sel_26: global176)
		((ScriptID 15 1) ; invWin
			sel_25: 0
			sel_26: global176
			sel_367: global176
			sel_368: global176
			sel_369: global176
			sel_370: global176
			sel_374: global168
			sel_375: global172
			sel_376: global172
			sel_377: global173
			sel_378: global173
		)
		((ScriptID 21 0) sel_57: 257) ; addCluesCode
		((ScriptID 21 0) sel_57: 258) ; addCluesCode
		((ScriptID 21 0) sel_57: 259) ; addCluesCode
		((ScriptID 21 0) sel_57: 260) ; addCluesCode
		((ScriptID 21 0) sel_57: 261) ; addCluesCode
		((ScriptID 21 0) sel_57: 262) ; addCluesCode
		((ScriptID 21 0) sel_57: 273) ; addCluesCode
		((ScriptID 21 0) sel_57: 513) ; addCluesCode
		((ScriptID 21 0) sel_57: 514) ; addCluesCode
		((ScriptID 21 0) sel_57: 515) ; addCluesCode
		((ScriptID 21 0) sel_57: 516) ; addCluesCode
		((ScriptID 21 0) sel_57: 517) ; addCluesCode
		((ScriptID 21 0) sel_57: 518) ; addCluesCode
		((ScriptID 21 0) sel_57: 519) ; addCluesCode
		((ScriptID 21 0) sel_57: 771) ; addCluesCode
		((ScriptID 21 0) sel_57: 1026) ; addCluesCode
		((ScriptID 21 0) sel_57: 1027) ; addCluesCode
		((ScriptID 21 0) sel_57: 1028) ; addCluesCode
		(DisposeScript 21)
		(DisposeScript 12)
	)
)
