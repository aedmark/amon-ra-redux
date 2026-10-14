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
		name {lb2InitCode}
	)

	(method (init &tmp temp0)
		(= gPossibleScore 1000)
		(= gUserFont 69)
		(= gBigFont 2108)
		(= gSmallFont 1207)
		(= global118 2407)
		(= global119 4115)
		(= global120 2510)
		(Print font: gUserFont)
		((= gNarrator Narrator) font: gUserFont back: 15 keepWindow: 1)
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
		(gGame setCursor: gTheCursor 1 304 172 detailLevel: 5)
		(= gTextSpeed 2)
		(= global106 (DoSound sndGET_POLYPHONY))
		(if (and (>= (= global105 (Graph grGET_COLOURS)) 2) (<= global105 16))
			(ClearFlag 0)
		else
			(SetFlag 0)
		)
		(gSystemWindow color: 0 back: global176)
		((ScriptID 15 1) ; invWin
			color: 0
			back: global176
			topBordColor: global176
			lftBordColor: global176
			rgtBordColor: global176
			botBordColor: global176
			insideColor: global168
			topBordColor2: global172
			lftBordColor2: global172
			botBordColor2: global173
			rgtBordColor2: global173
		)
		((ScriptID 21 0) doit: 257) ; addCluesCode
		((ScriptID 21 0) doit: 258) ; addCluesCode
		((ScriptID 21 0) doit: 259) ; addCluesCode
		((ScriptID 21 0) doit: 260) ; addCluesCode
		((ScriptID 21 0) doit: 261) ; addCluesCode
		((ScriptID 21 0) doit: 262) ; addCluesCode
		((ScriptID 21 0) doit: 273) ; addCluesCode
		((ScriptID 21 0) doit: 513) ; addCluesCode
		((ScriptID 21 0) doit: 514) ; addCluesCode
		((ScriptID 21 0) doit: 515) ; addCluesCode
		((ScriptID 21 0) doit: 516) ; addCluesCode
		((ScriptID 21 0) doit: 517) ; addCluesCode
		((ScriptID 21 0) doit: 518) ; addCluesCode
		((ScriptID 21 0) doit: 519) ; addCluesCode
		((ScriptID 21 0) doit: 771) ; addCluesCode
		((ScriptID 21 0) doit: 1026) ; addCluesCode
		((ScriptID 21 0) doit: 1027) ; addCluesCode
		((ScriptID 21 0) doit: 1028) ; addCluesCode
		(DisposeScript 21)
		(DisposeScript 12)
	)
)
