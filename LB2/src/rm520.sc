;;; Sierra Script 1.0 - (do not remove this comment)
(script# 520)
(include sci.sh)
(use Main)
(use LBRoom)
(use ExitFeature)
(use MuseumRgn)
(use Inset)
(use Scaler)
(use PolyPath)
(use CueObj)
(use n958)
(use StopWalk)
(use DPath)
(use Timer)
(use Sound)
(use Cycle)
(use InvI)
(use User)
(use View)
(use Obj)

(public
	rm520 0
	cobraLoose 1
)

(local
	[local0 2] = [0 1]
	theSCobraLoose
	local3
	local4
	local5 =  1
	local6 =  1
	local7
	local8
	local9 =  100
	local10
)
(instance rm520 of LBRoom
	(properties
		sel_20 {rm520}
		sel_213 58
		sel_408 520
		sel_409 666
		sel_411 510
		sel_107 0
	)
	
	(method (sel_110)
		(proc958_0
			128
			520
			521
			522
			523
			524
			525
			526
			527
			528
			529
			563
			820
			561
			831
		)
		(proc958_0 129 521 522 523)
		(proc958_0 132 520 524 521 522 523 525 441 481 49 721)
		(gEgo sel_110: sel_585: 831 sel_320: Scaler 120 100 190 0)
		(self sel_414: 90)
		(switch gGSel_40
			(sel_411
				(gEgo sel_1: 160)
				(gGame sel_588:)
			)
			(456
				(gEgo sel_1: 209 sel_0: 127)
			)
			(else 
				(gEgo sel_153: 109 125 sel_253: 62)
			)
		)
		(gGame sel_588:)
		(super sel_110:)
		(cond 
			(
				(and
					(or
						(> global123 4)
						(and (== global123 4) (proc0_10 16648 1))
					)
					(!= gGSel_40 525)
					(!= gGSel_40 456)
					(not (proc0_10 16648))
				)
				(gGameMusic2 sel_40: 521 sel_3: -1 sel_99: 1 sel_39:)
			)
			((!= gGSel_40 456) (gGameMusic2 sel_40: 520 sel_3: -1 sel_99: 1 sel_39:))
		)
		(if
		(and (== gGSel_40 525) (not (proc0_10 16648)))
			((Timer sel_109:) sel_162: self 2)
		)
		(if
			(or
				(> global123 4)
				(and (== global123 4) (proc0_10 16648 1))
			)
			(if (not (proc0_2 80))
				(cobraDoor sel_110:)
				(= local5 0)
				(= theSCobraLoose sCobraLoose)
			else
				(cobra sel_110: sel_311: 4 1 8 sel_313:)
			)
		else
			(mountedSkull sel_110: sel_311: 4 1 8 sel_313:)
			(cobra sel_110: sel_311: 4 1 8 sel_313:)
		)
		(if (not (proc0_2 49))
			(rosettaCloth sel_110: sel_311: 4 1 8 sel_313:)
		)
		(if
			(and
				(or
					(< global123 4)
					(and (== global123 4) (not (proc0_10 12548)))
				)
				(not (proc0_2 48))
			)
			(snakeOil sel_110: sel_311: 4 1 8 sel_313:)
		)
		(secretDoor sel_110: sel_313:)
		(if
			(or
				(> global123 4)
				(and (== global123 4) (proc0_10 16648 1))
			)
			(deadCountess sel_110: sel_313: sel_311: 1 8)
		else
			(intercom sel_110: sel_313: sel_311: 4 1 8)
		)
		(ratBack sel_110: sel_311: 4 1 8)
		(ratFore sel_110: sel_311: 4 1 8)
		(rosetta sel_110: sel_311: 4 1 8)
		(hieroglyphics sel_110: sel_311: 4 1 8)
		(certificate sel_110:)
		(skeletonLegs sel_110:)
		(cobraCage sel_110:)
		(bookShelf sel_110:)
		(jars sel_110:)
		(chair sel_110:)
		(skeletonFore sel_110:)
		(desk sel_110:)
		(windowView sel_110:)
		(drapes sel_110:)
		(roachTop sel_110:)
		(roachBottom sel_110:)
		(displayCase sel_110:)
		(cages sel_110:)
		(lizards sel_110:)
		(bookcase sel_110:)
		(lizardTable sel_110:)
		(standRat sel_110:)
		(if theSCobraLoose (global2 sel_146: theSCobraLoose))
		(southExitFeature sel_110:)
	)
	
	(method (sel_57)
		(super sel_57:)
		(cond 
			(sel_142)
			((and local4 (proc0_1 gEgo 16)) (self sel_146: sDropCobraGetBitten))
			(
				(and
					(> (gEgo sel_0?) 185)
					(or
						(== (gEgo sel_2?) 522)
						(== (gEgo sel_2?) 528)
						(== (gEgo sel_2?) 529)
					)
				)
				(global2 sel_146: sDropCobraGetBitten)
			)
			((> (gEgo sel_0?) 185) (= local4 1))
		)
	)
	
	(method (sel_145)
		(if local10
			(super sel_399: 26)
		else
			(gGameMusic2 sel_40: 520)
			((ScriptID 22 0) sel_57: 16648)
		)
	)
	
	(method (sel_399 param1)
		(cond 
			((== param1 456) (super sel_399: param1))
			((and (== global123 4) (gEgo sel_238: 31))
				(= param1 26)
				(WrapMusic sel_111:)
				((ScriptID 22 0) sel_57: 31)
				(gGameMusic2 sel_40: 524 sel_3: 1 sel_99: 1 sel_39: self)
				(= local10 1)
			)
			(else (gGameMusic2 sel_170:) (super sel_399: param1))
		)
		((ScriptID 90 2) sel_63: -1)
	)
)

(instance cobra of Actor
	(properties
		sel_20 {cobra}
		sel_1 85
		sel_0 58
		sel_213 16
		sel_303 78
		sel_304 122
		sel_2 521
		sel_3 3
		sel_60 2
		sel_14 16400
		sel_244 12
	)
	
	(method (sel_300 param1)
		(switch param1
			(1 (global2 sel_422: inCobra))
			(8 (global2 sel_422: inCobra))
			(else  (super sel_300: param1))
		)
	)
)

(instance cobraLoose of Actor
	(properties
		sel_20 {cobraLoose}
		sel_1 77
		sel_0 178
		sel_2 521
		sel_244 12
	)
	
	(method (sel_57)
		(if
			(and
				(not local4)
				(not (cobraDoor sel_142?))
				(not local5)
			)
			(cond 
				(
					(and
						local8
						(or
							(< (gEgo sel_255: self) 40)
							(> (gEgo sel_255: self) local9)
						)
					)
					(cobraDoor sel_146: sCobraStrike)
				)
				((and (< (gEgo sel_1?) (self sel_1?)) local6) (= local6 0) (self sel_146: sCobraTurn))
				(
				(and (> (gEgo sel_1?) (self sel_1?)) (not local6)) (= local6 1) (self sel_146: sCobraTurn))
			)
		)
		(super sel_57:)
	)
	
	(method (sel_300 param1)
		(switch param1
			(25
				(switch local3
					(0
						(if (< (gEgo sel_0?) 152)
							(gEgo sel_312: MoveTo 158 130)
							(= local3 1)
						else
							(gEgo sel_312: MoveTo 160 189)
							(= local3 11)
						)
					)
					(else 
						(if (gEgo sel_238: 14) (++ local3))
					)
				)
				(cond 
					(
					(or (> local3 13) (and (> local3 3) (< local3 9)))
						(= global150 0)
						(-- local3)
						(gLb2Messager sel_295: 30 0 5)
					)
					((> global150 0) (-- global150) (cobraDoor sel_146: sLauraOil))
					(else (gLb2Messager sel_295: 30 0 5))
				)
			)
			(30
				(switch local3
					(3
						(gEgo sel_146: 0)
						(= local4 1)
						(cobraDoor sel_146: sLauraLasso3)
					)
					(13
						(gEgo sel_146: 0)
						(= local4 1)
						(cobraDoor sel_146: sLauraLasso13)
					)
					(else 
						(cobraDoor sel_146: sCobraStrike)
					)
				)
			)
			(4
				(cobraDoor sel_146: sCobraStrike)
			)
			(1
				(global2 sel_146: sShowCobraLoose)
			)
			(8
				(global2 sel_146: sShowCobraLoose)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance cobraDoor of Prop
	(properties
		sel_20 {cobraDoor}
		sel_1 108
		sel_0 28
		sel_213 29
		sel_2 521
		sel_3 8
		sel_4 6
		sel_60 2
		sel_14 16
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (self sel_300: 30))
			(30
				(cond 
					(local4 (self sel_146: sPutCobraBack))
					((== (self sel_4?) 0) (self sel_161: End))
					(else (self sel_161: Beg))
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance bigCobra of View
	(properties
		sel_20 {bigCobra}
		sel_1 34
		sel_0 79
		sel_2 521
		sel_3 13
		sel_4 3
		sel_60 15
		sel_14 16
	)
)

(instance rosettaCloth of View
	(properties
		sel_20 {rosettaCloth}
		sel_1 223
		sel_0 105
		sel_213 21
		sel_303 210
		sel_304 131
		sel_2 521
		sel_3 13
		sel_60 9
		sel_14 16400
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(if
					(or
						(== (gEgo sel_2?) 522)
						(== (gEgo sel_2?) 528)
						(== (gEgo sel_2?) 529)
					)
					(gLb2Messager sel_295: 58 0 7)
				else
					(global2 sel_146: sRemoveCloth)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance snakeOil of View
	(properties
		sel_20 {snakeOil}
		sel_1 113
		sel_0 104
		sel_82 10
		sel_213 30
		sel_303 130
		sel_304 145
		sel_2 520
		sel_3 3
		sel_60 8
		sel_14 16
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(global2 sel_422: inSnakeOil)
			)
			(8 (self sel_300: 1))
			(4 (self sel_300: 1))
			(else  (super sel_300: param1))
		)
	)
)

(instance mountedSkull of Prop
	(properties
		sel_20 {mountedSkull}
		sel_1 98
		sel_0 74
		sel_213 31
		sel_303 91
		sel_304 141
		sel_2 520
		sel_3 4
		sel_60 8
		sel_14 16
		sel_244 18
	)
	
	(method (sel_300 param1)
		(return
			(switch param1
				(4
					(cond 
						(
							(or
								(== (gEgo sel_2?) 522)
								(== (gEgo sel_2?) 528)
								(== (gEgo sel_2?) 529)
							)
							(gLb2Messager sel_295: 58 0 7)
						)
						((MuseumRgn sel_646:) (self sel_146: sSecretDoor))
						(else (return 1))
					)
				)
				(else  (super sel_300: param1))
			)
		)
	)
)

(instance secretDoor of Prop
	(properties
		sel_20 {secretDoor}
		sel_1 294
		sel_0 159
		sel_2 524
		sel_3 1
		sel_244 12
	)
)

(instance intercom of View
	(properties
		sel_20 {intercom}
		sel_1 179
		sel_0 96
		sel_213 32
		sel_303 152
		sel_304 135
		sel_2 520
		sel_3 3
		sel_4 1
		sel_60 8
		sel_14 16
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(global2 sel_422: inIntercom)
			)
			(8 (self sel_300: 1))
			(4 (self sel_300: 1))
			(else  (super sel_300: param1))
		)
	)
)

(instance deadCountess of View
	(properties
		sel_20 {deadCountess}
		sel_1 111
		sel_0 89
		sel_55 90
		sel_213 33
		sel_303 109
		sel_304 125
		sel_2 524
		sel_60 8
		sel_14 16400
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if local5
					(gEgo sel_253: 62)
					(gGame sel_87: 1 163)
					(global2 sel_399: 525)
				else
					(gLb2Messager sel_295: 58 0 7)
				)
			)
			(8 (self sel_300: 1))
			(else  (super sel_300: param1))
		)
	)
)

(instance ratFore of Feature
	(properties
		sel_20 {ratFore}
		sel_1 281
		sel_0 200
		sel_213 14
		sel_302 4
		sel_303 225
		sel_304 171
	)
	
	(method (sel_300 param1)
		(switch param1
			(8 (global2 sel_422: inRatFore))
			(else  (super sel_300: param1))
		)
	)
)

(instance ratBack of Feature
	(properties
		sel_20 {ratBack}
		sel_1 88
		sel_0 21
		sel_213 14
		sel_6 14
		sel_7 74
		sel_8 29
		sel_9 103
		sel_303 80
		sel_304 113
	)
	
	(method (sel_300 param1)
		(switch param1
			(8 (global2 sel_422: inRatBack))
			(else  (super sel_300: param1))
		)
	)
)

(instance rosetta of Feature
	(properties
		sel_20 {rosetta}
		sel_1 293
		sel_0 104
		sel_55 90
		sel_213 34
		sel_301 40
		sel_302 256
		sel_303 210
		sel_304 131
	)
	
	(method (sel_300 param1 &tmp temp0)
		(switch param1
			(8
				(if
					(or
						(== (gEgo sel_2?) 522)
						(== (gEgo sel_2?) 528)
						(== (gEgo sel_2?) 529)
					)
					(gLb2Messager sel_295: 58 0 7)
				else
					(gGame sel_87: 1 137)
					((ScriptID 21 0) sel_57: 1025)
					(= temp0 14)
					(while (< temp0 27)
						((ScriptID 21 0) sel_57: (+ temp0 1088))
						(++ temp0)
					)
					(global2 sel_399: 456)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance certificate of Feature
	(properties
		sel_20 {certificate}
		sel_0 1
	)
	
	(method (sel_218 param1)
		(if (super sel_218: param1)
			(cond 
				(
					(and
						(<= 188 gSel_1)
						(<= gSel_1 206)
						(<= 20 gSel_0)
						(<= gSel_0 43)
					)
					(= sel_1 197)
					(= sel_0 31)
					(= sel_82 0)
					(= sel_213 2)
				)
				(
					(and
						(<= 185 gSel_1)
						(<= gSel_1 210)
						(<= 51 gSel_0)
						(<= gSel_0 72)
					)
					(= sel_1 197)
					(= sel_0 61)
					(= sel_82 0)
					(= sel_213 3)
				)
				(
					(and
						(<= 222 gSel_1)
						(<= gSel_1 240)
						(<= 17 gSel_0)
						(<= gSel_0 37)
					)
					(= sel_1 231)
					(= sel_0 27)
					(= sel_82 0)
					(= sel_213 4)
				)
				(
					(and
						(<= 246 gSel_1)
						(<= gSel_1 274)
						(<= 15 gSel_0)
						(<= gSel_0 38)
					)
					(= sel_1 260)
					(= sel_0 26)
					(= sel_82 0)
					(= sel_213 5)
				)
			)
		)
	)
)

(instance skeletonLegs of Feature
	(properties
		sel_20 {skeletonLegs}
		sel_1 302
		sel_0 134
		sel_213 6
		sel_7 285
		sel_8 68
		sel_9 319
		sel_301 40
	)
)

(instance cobraCage of Feature
	(properties
		sel_20 {cobraCage}
		sel_1 93
		sel_0 46
		sel_213 7
		sel_6 29
		sel_7 78
		sel_8 63
		sel_9 109
		sel_301 40
		sel_303 81
		sel_304 116
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(if local4
					(cobraDoor sel_146: sPutCobraBack)
				else
					(super sel_300: param1 &rest)
				)
			)
			(30 (self sel_300: 4))
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance bookShelf of Feature
	(properties
		sel_20 {bookShelf}
		sel_1 91
		sel_0 70
		sel_213 8
		sel_6 65
		sel_7 78
		sel_8 76
		sel_9 104
		sel_301 40
	)
)

(instance jars of Feature
	(properties
		sel_20 {jars}
	)
	
	(method (sel_218 param1)
		(if (super sel_218: param1)
			(cond 
				(
					(and
						(<= 81 gSel_1)
						(<= gSel_1 88)
						(<= 79 gSel_0)
						(<= gSel_0 90)
					)
					(= sel_1 85)
					(= sel_0 83)
					(= sel_82 0)
					(= sel_213 9)
				)
				(
					(and
						(<= 92 gSel_1)
						(<= gSel_1 101)
						(<= 79 gSel_0)
						(<= gSel_0 87)
					)
					(= sel_1 96)
					(= sel_0 83)
					(= sel_82 0)
					(= sel_213 10)
				)
				(
					(and
						(<= 80 gSel_1)
						(<= gSel_1 90)
						(<= 90 gSel_0)
						(<= gSel_0 97)
					)
					(= sel_1 85)
					(= sel_0 93)
					(= sel_82 0)
					(= sel_213 11)
				)
			)
		)
	)
)

(instance chair of Feature
	(properties
		sel_20 {chair}
		sel_1 144
		sel_0 82
		sel_213 12
		sel_6 76
		sel_7 134
		sel_8 88
		sel_9 154
		sel_301 40
	)
)

(instance skeletonFore of Feature
	(properties
		sel_20 {skeletonFore}
		sel_1 260
		sel_0 164
		sel_213 13
		sel_301 40
		sel_302 2
	)
)

(instance desk of Feature
	(properties
		sel_20 {desk}
		sel_0 88
		sel_213 15
		sel_301 40
		sel_302 8
	)
)

(instance windowView of Feature
	(properties
		sel_20 {windowView}
		sel_0 47
		sel_213 28
		sel_301 40
		sel_302 16
	)
)

(instance drapes of Feature
	(properties
		sel_20 {drapes}
		sel_0 12
		sel_213 17
		sel_301 40
		sel_302 32
	)
)

(instance roachTop of Feature
	(properties
		sel_20 {roachTop}
		sel_0 55
		sel_213 18
		sel_301 40
		sel_302 64
	)
)

(instance roachBottom of Feature
	(properties
		sel_20 {roachBottom}
		sel_0 102
		sel_213 19
		sel_301 40
		sel_302 -32768
	)
)

(instance displayCase of Feature
	(properties
		sel_20 {displayCase}
		sel_1 320
		sel_0 77
		sel_213 20
		sel_301 40
		sel_302 128
	)
)

(instance cages of Feature
	(properties
		sel_20 {cages}
		sel_1 320
		sel_0 128
		sel_213 22
		sel_301 40
		sel_302 512
	)
)

(instance lizards of Feature
	(properties
		sel_20 {lizards}
		sel_0 180
		sel_213 23
		sel_301 40
		sel_302 1024
	)
)

(instance bookcase of Feature
	(properties
		sel_20 {bookcase}
		sel_0 1
		sel_213 25
		sel_301 40
		sel_302 4096
	)
)

(instance lizardTable of Feature
	(properties
		sel_20 {lizardTable}
		sel_0 183
		sel_213 26
		sel_301 40
		sel_302 8192
	)
)

(instance standRat of Feature
	(properties
		sel_20 {standRat}
		sel_1 260
		sel_0 180
		sel_213 27
		sel_301 40
		sel_302 16384
	)
)

(instance inCobra of Inset
	(properties
		sel_20 {inCobra}
		sel_2 521
		sel_3 13
		sel_4 1
		sel_1 77
		sel_0 23
		sel_570 1
		sel_213 54
	)
	
	(method (sel_110)
		(if
			(not
				(cond 
					((> global123 4))
					((== global123 4) (proc0_10 16648 1))
				)
			)
			(fang sel_110:)
		)
		(super sel_110: &rest)
	)
	
	(method (sel_111)
		(fang sel_111:)
		(super sel_111:)
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if
					(or
						(> global123 4)
						(and (== global123 4) (proc0_10 16648 1))
					)
					(gLb2Messager sel_295: sel_213 1 8)
				else
					(gLb2Messager sel_295: sel_213 1 9)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance hieroglyphics of Feature
	(properties
		sel_20 {hieroglyphics}
		sel_1 250
		sel_0 65
		sel_55 90
		sel_213 24
		sel_301 90
		sel_302 2048
		sel_303 210
		sel_304 131
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if
					(or
						(== (gEgo sel_2?) 522)
						(== (gEgo sel_2?) 528)
						(== (gEgo sel_2?) 529)
					)
					(gLb2Messager sel_295: 58 0 7)
				else
					(gGame sel_587:)
					(global2 sel_146: sHieroglyphics)
				)
			)
			(8 (self sel_300: 1))
			(else  (super sel_300: param1))
		)
	)
)

(instance fang of View
	(properties
		sel_20 {fang}
		sel_1 93
		sel_0 32
		sel_2 521
		sel_3 13
		sel_4 2
		sel_60 15
		sel_14 16
	)
)

(instance inSnakeOil of Inset
	(properties
		sel_20 {inSnakeOil}
		sel_2 520
		sel_3 2
		sel_1 127
		sel_0 33
		sel_60 15
		sel_570 1
		sel_213 38
	)
	
	(method (sel_111)
		(global2 sel_146: sOlympiaOil)
		(super sel_111:)
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (self sel_111:))
			(else  (super sel_300: param1))
		)
	)
)

(instance inIntercom of Inset
	(properties
		sel_20 {inIntercom}
		sel_2 520
		sel_1 162
		sel_0 79
		sel_570 1
		sel_213 39
	)
)

(instance inRatFore of Inset
	(properties
		sel_20 {inRatFore}
		sel_2 520
		sel_3 1
		sel_1 232
		sel_0 147
		sel_60 15
		sel_570 1
		sel_213 40
	)
)

(instance inRatBack of Inset
	(properties
		sel_20 {inRatBack}
		sel_2 520
		sel_3 1
		sel_1 72
		sel_0 6
		sel_570 1
		sel_213 41
	)
)

(instance inHieroglyphics of Inset
	(properties
		sel_20 {inHieroglyphics}
		sel_408 522
		sel_213 24
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(proc0_8 1)
		(gLb2WH sel_129: self)
	)
	
	(method (sel_111)
		(gLb2WH sel_81: self)
		(proc0_8 0)
		(super sel_111:)
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(= sel_408 (if (== sel_408 522) 523 else 522))
				(sFX sel_40: 525 sel_99: 1 sel_39:)
				(DrawPic sel_408 (if (== sel_408 522) 11 else 12))
			)
			(13 (self sel_111:))
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance sHieroglyphics of Script
	(properties
		sel_20 {sHieroglyphics}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGameMusic2 sel_170: 80 20 20 0)
				(= sel_136 1)
			)
			(1
				(gSel_561 sel_119: 102)
				(gGame sel_587:)
				(User sel_347: 1)
				(gIconBar sel_177: 0 2 1)
				(global2 sel_422: inHieroglyphics self)
			)
			(2
				(if (not (gEgo sel_238: 14)) (snakeOil sel_216:))
				(gGame sel_588:)
				(gSel_561 sel_119: 216)
				(= sel_136 1)
			)
			(3
				(gGameMusic2 sel_170: 127 20 20 0)
				(self sel_111:)
			)
		)
	)
)

(instance sRemoveCloth of Script
	(properties
		sel_20 {sRemoveCloth}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 215 126 self)
			)
			(1
				(rosettaCloth sel_111:)
				(proc0_3 49)
				(gEgo sel_2: 521 sel_155: 14 sel_156: 0 sel_161: End self)
			)
			(2
				(gEgo sel_585: 831 sel_253: 90)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sOlympiaOil of Script
	(properties
		sel_20 {sOlympiaOil}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_313:)
				(if (== ((ScriptID 90 2) sel_620?) gSel_40)
					((ScriptID 90 2)
						sel_63: 13
						sel_312: DPath 128 183 102 160 95 125 self
					)
				else
					((ScriptID 90 2)
						sel_182: gSel_40
						sel_153: 170 250
						sel_63: 13
						sel_312: DPath 128 183 102 160 95 125 self
					)
				)
			)
			(1
				(proc0_5 (ScriptID 90 2) gEgo)
				(= sel_136 1)
			)
			(2
				(proc0_3 48)
				((ScriptID 90 2)
					sel_2: 525
					sel_155: 2
					sel_156: 0
					sel_161: End self
				)
			)
			(3 (= sel_139 30))
			(4
				(snakeOil sel_111:)
				((ScriptID 90 2) sel_161: Beg self)
			)
			(5
				((ScriptID 90 2)
					sel_2: 820
					sel_155: -1
					sel_161: Walk
					sel_312:
						MoveTo
						(+ ((ScriptID 90 2) sel_1?) 10)
						((ScriptID 90 2) sel_0?)
						self
				)
			)
			(6
				((ScriptID 90 2) sel_253: 180)
				(= sel_136 1)
			)
			(7
				((ScriptID 90 2) sel_161: StopWalk -1)
				(= sel_139 120)
			)
			(8
				(gLb2Messager sel_295: 1 0 1 0 self 1520)
			)
			(9
				((ScriptID 90 2)
					sel_2: 820
					sel_161: Walk
					sel_312: DPath 102 160 128 183 170 250 self
				)
			)
			(10
				((ScriptID 90 2) sel_182: -2)
				(gEgo sel_315:)
				((Inv sel_64: 14) sel_166: 0)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sCobraLoose of Script
	(properties
		sel_20 {sCobraLoose}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_136 2))
			(1 (= sel_139 180))
			(2
				(sFX sel_40: 522 sel_99: 1 sel_39:)
				(= sel_136 2)
			)
			(3
				(gEgo sel_253: 270)
				(= sel_139 60)
			)
			(4
				(cobraLoose
					sel_110:
					sel_155: 0
					sel_161: Fwd
					sel_312: MoveTo 86 158 self
				)
			)
			(5
				(proc0_5 gEgo cobraLoose)
				(cobraLoose sel_161: End self)
			)
			(6
				(cobraLoose
					sel_155: 9
					sel_156: 0
					sel_153: 90 159
					sel_161: End self
				)
			)
			(7
				(cobraLoose
					sel_155: 11
					sel_156: 0
					sel_153: 92 159
					sel_161: Fwd
				)
				(= sel_139 30)
			)
			(8
				(sFX sel_40: 522 sel_99: 1 sel_39:)
				(bigCobra sel_110:)
				(= sel_139 180)
			)
			(9
				(bigCobra sel_111:)
				(= local8 1)
				(gEgo sel_146: sCobraTimer)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sShowCobraLoose of Script
	(properties
		sel_20 {sShowCobraLoose}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(sFX sel_40: 522 sel_99: 1 sel_39:)
				(bigCobra
					sel_110:
					sel_1: (- (cobraLoose sel_1?) 58)
					sel_0: (- (cobraLoose sel_0?) 80)
				)
				(= sel_139 180)
			)
			(1
				(bigCobra sel_111:)
				(= sel_139 60)
			)
			(2
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sLauraOil of Script
	(properties
		sel_20 {sLauraOil}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_146: 0)
				(if (< local3 9)
					(gEgo sel_312: PolyPath 158 130 self)
				else
					(gEgo sel_312: PolyPath 160 179 self)
				)
			)
			(1
				(switch local3
					(1 (= local7 0))
					(2 (= local7 0))
					(3 (= local7 1))
					(11 (= local7 2))
					(12 (= local7 2))
					(13 (= local7 3))
				)
				(gEgo
					sel_2: 522
					sel_155: local7
					sel_156: 0
					sel_161: End self
				)
			)
			(2
				(switch local3
					(1
						(cobraLoose sel_155: 0 sel_312: MoveTo 147 177 self)
					)
					(2
						(cobraLoose sel_155: 0 sel_312: MoveTo 213 171 self)
					)
					(3
						(= local9 120)
						(cobraLoose sel_155: 0 sel_312: MoveTo 260 150 self)
					)
					(11
						(cobraLoose sel_155: 0 sel_312: MoveTo 128 134 self)
					)
					(12
						(cobraLoose sel_155: 0 sel_312: MoveTo 187 133 self)
					)
					(13
						(cobraLoose sel_155: 15 sel_312: PolyPath 207 107 self)
					)
				)
			)
			(3
				(gEgo sel_585: 831)
				(proc0_5 gEgo cobraLoose)
				(= sel_136 1)
			)
			(4
				(cobraLoose sel_155: 4 sel_156: 0 sel_161: End self)
			)
			(5
				(if (< (cobraLoose sel_1?) (gEgo sel_1?))
					(cobraLoose sel_155: 9 sel_156: 0 sel_161: End self)
				else
					(cobraLoose sel_155: 10 sel_156: 0 sel_161: End self)
				)
			)
			(6
				(if (< (cobraLoose sel_1?) (gEgo sel_1?))
					(cobraLoose sel_155: 11 sel_156: 0 sel_161: Fwd)
				else
					(cobraLoose sel_155: 12 sel_156: 0 sel_161: Fwd)
				)
				(= sel_136 1)
			)
			(7
				(if (< (gEgo sel_1?) (cobraLoose sel_1?))
					(= local6 0)
				else
					(= local6 1)
				)
				(gEgo sel_146: sCobraTimer)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sLauraLasso3 of Script
	(properties
		sel_20 {sLauraLasso3}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: MoveTo 216 151 self)
			)
			(1 (= sel_136 2))
			(2
				(gEgo sel_2: 522 sel_161: 0 sel_155: 5 sel_156: 0)
				(= sel_139 30)
			)
			(3
				(cobraLoose sel_155: 3 sel_156: 0 sel_161: 0)
				(= sel_136 1)
			)
			(4 (gEgo sel_161: CT 3 1 self))
			(5
				(cobraLoose sel_102: sel_111:)
				(gEgo sel_161: End self)
			)
			(6
				(gEgo
					sel_2: 528
					sel_155: 0
					sel_156: 0
					sel_153: 220 152
					sel_155: -1
					sel_161: StopWalk 529
				)
				(= sel_139 60)
			)
			(7
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sLauraLasso13 of Script
	(properties
		sel_20 {sLauraLasso13}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= local4 1)
				(gEgo sel_585: 831 sel_312: MoveTo 209 127 self)
			)
			(1
				(gEgo
					sel_2: 522
					sel_320: Scaler 110 90 190 0
					sel_155: 6
					sel_156: 0
					sel_161: StopWalk
				)
				(= sel_136 1)
			)
			(2
				(cobraLoose sel_102: sel_111:)
				(gEgo sel_2: 522 sel_155: 6 sel_4: 0 sel_161: End self)
			)
			(3 (gEgo sel_161: Beg self))
			(4
				(gEgo
					sel_2: 528
					sel_155: 3
					sel_156: 6
					sel_153: 211 128
					sel_155: -1
					sel_161: StopWalk 529
				)
				(= sel_139 60)
			)
			(5
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sCobraStrike of Script
	(properties
		sel_20 {sCobraStrike}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(proc0_5 gEgo cobraLoose)
				(= local4 1)
				(cobraLoose sel_15: 0 sel_316: 1)
				(if local6
					(cobraLoose
						sel_155: 0
						sel_161: Fwd
						sel_312: PolyPath (- (gEgo sel_1?) 34) (+ (gEgo sel_0?) 10) self
					)
				else
					(cobraLoose
						sel_155: 1
						sel_161: Fwd
						sel_312: PolyPath (+ (gEgo sel_1?) 35) (+ (gEgo sel_0?) 11) self
					)
				)
			)
			(1
				(gGameMusic2 sel_167:)
				(sFX sel_40: 523 sel_99: 1 sel_39:)
				(if local6
					(cobraLoose
						sel_155: 2
						sel_156: 0
						sel_153: (- (gEgo sel_1?) 21) (+ (gEgo sel_0?) 6)
						sel_161: CT 4 1 self
					)
				else
					(cobraLoose
						sel_155: 3
						sel_156: 0
						sel_153: (+ (gEgo sel_1?) 21) (+ (gEgo sel_0?) 7)
						sel_161: CT 4 1 self
					)
				)
			)
			(2
				(cobraLoose sel_161: End self)
				(sFX sel_40: 481 sel_99: 5 sel_155: 1 sel_39:)
			)
			(3
				(gEgo
					sel_2: 523
					sel_155: 0
					sel_156: 0
					sel_153: (+ (gEgo sel_1?) 15) (+ (gEgo sel_0?) 1)
					sel_161: End self
				)
			)
			(4
				(= global145 11)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sPutCobraBack of Script
	(properties
		sel_20 {sPutCobraBack}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= local4 0)
				(gEgo sel_161: Walk sel_312: PolyPath 132 95 self)
			)
			(1
				(gEgo
					sel_2: 522
					sel_155: 4
					sel_156: 0
					sel_153: 126 98
					sel_161: CT 6 1 self
				)
			)
			(2
				(cobraDoor sel_161: End self)
			)
			(3
				(gGameMusic2 sel_170:)
				(gEgo sel_161: CT 9 1 self)
			)
			(4
				(cobra sel_110: sel_313:)
				(= sel_136 1)
			)
			(5
				(gEgo sel_161: End)
				(cobraDoor sel_161: Beg self)
			)
			(6
				(sFX sel_40: 441 sel_99: 5 sel_155: 1 sel_39:)
				(gGame sel_87: 1 164)
				(= local5 1)
				(proc0_3 80)
				(cobraLoose sel_102:)
				(gEgo
					sel_585: 831
					sel_320: Scaler 120 100 190 0
					sel_14: 16384
					sel_253: 270
				)
				(gGameMusic2 sel_40: 520 sel_3: -1 sel_99: 1 sel_39:)
				(= sel_136 1)
			)
			(7
				(cobraDoor sel_313:)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sDropCobraGetBitten of Script
	(properties
		sel_20 {sDropCobraGetBitten}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= local4 0)
				(gEgo sel_2: 522 sel_155: 7 sel_156: 0 sel_161: End self)
			)
			(1 (= sel_139 60))
			(2
				(cobraLoose
					sel_216:
					sel_155: 4
					sel_156: 3
					sel_1: (+ (gEgo sel_1?) 4)
					sel_0: (+ (gEgo sel_0?) 3)
				)
				(gEgo sel_2: 523 sel_155: 0 sel_156: 0 sel_161: End self)
			)
			(3
				(= global145 11)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sCobraTurn of Script
	(properties
		sel_20 {sCobraTurn}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(if local6
					(cobraLoose sel_155: 5 sel_156: 0 sel_161: End self)
				else
					(cobraLoose sel_155: 4 sel_156: 0 sel_161: End self)
				)
			)
			(1
				(if local6
					(cobraLoose sel_155: 11 sel_156: 0 sel_161: End self)
				else
					(cobraLoose sel_155: 12 sel_156: 0 sel_161: End self)
				)
			)
			(2 (self sel_111:))
		)
	)
)

(instance sCobraTimer of Script
	(properties
		sel_20 {sCobraTimer}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_137 15))
			(1
				(gEgo sel_146: sCobraStrike)
				(self sel_111:)
			)
		)
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 1
	)
)

(instance southExitFeature of ExitFeature
	(properties
		sel_20 {southExitFeature}
		sel_6 184
		sel_7 115
		sel_8 189
		sel_9 245
		sel_33 11
		sel_583 3
		sel_213 57
	)
)

(instance sSecretDoor of Script
	(properties
		sel_20 {sSecretDoor}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 93 122 self)
			)
			(1
				(proc0_5 gEgo mountedSkull)
				(= sel_136 4)
			)
			(2
				(gEgo sel_2: 561 sel_155: 0 sel_156: 0 sel_161: End self)
			)
			(3
				(gEgo sel_244: 12 sel_161: Beg self)
				(sFX sel_40: 49 sel_99: 5 sel_155: 1 sel_39:)
				(mountedSkull sel_161: End self)
			)
			(4 0)
			(5
				(gEgo sel_585: 831)
				(proc0_5 gEgo secretDoor)
				(sFX sel_40: 721 sel_99: 5 sel_155: 1 sel_39:)
				(secretDoor sel_161: End self)
			)
			(6
				(sFX sel_167:)
				(gEgo sel_312: PolyPath 315 167 self)
			)
			(7
				(gEgo sel_312: MoveTo 330 167 self)
			)
			(8
				(gEgo sel_63: 2)
				(sFX sel_40: 721 sel_99: 5 sel_155: 1 sel_39:)
				(secretDoor sel_161: Beg self)
			)
			(9
				(sFX sel_167:)
				(secretDoor sel_313:)
				(global2 sel_399: (global2 sel_409?))
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)
