;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 520)
(include sci.sh)
(use Main)
(use eRS)
(use ExitFeature)
(use MuseumRgn)
(use Inset)
(use Scaler)
(use PolyPath)
(use Feature)
(use LoadMany)
(use StopWalk)
(use DPath)
(use Timer)
(use Sound)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm520 0
	cobraLoose 1
)

(local
	[local0 2] = [0 1]
	local2
	local3
	local4
	local5 = 1
	local6 = 1
	local7
	local8
	local9 = 100
	local10
)

(instance rm520 of LBRoom
	(properties
		name {rm520}
		noun 58
		picture 520
		north 666
		south 510
		vanishingX 0
	)

	(method (init)
		(LoadMany rsVIEW 520 521 522 523 524 525 526 527 528 529 563 820 561 831)
		(LoadMany rsPIC 521 522 523)
		(LoadMany rsSOUND 520 524 521 522 523 525 441 481 49 721)
		(gEgo init: normalize: 831 setScale: Scaler 120 100 190 0)
		(self setRegions: 90)
		(switch gPrevRoomNum
			(south
				(gEgo x: 160)
				(gGame handsOn:)
			)
			(456 ; magRosetta
				(gEgo x: 209 y: 127)
			)
			(else
				(gEgo posn: 109 125 setHeading: 62)
			)
		)
		(gGame handsOn:)
		(super init:)
		(cond
			(
				(and
					(or
						(> gAct 4)
						(and (== gAct 4) (TimeCheck $4108 1)) ; can 4:15 am occur?
					)
					(!= gPrevRoomNum 525)
					(!= gPrevRoomNum 456) ; magRosetta
					(not (TimeCheck $4108)) ; has 4:15 am occurred?
				)
				(gGameMusic2 number: 521 loop: -1 flags: 1 play:)
			)
			((!= gPrevRoomNum 456) ; magRosetta
				(gGameMusic2 number: 520 loop: -1 flags: 1 play:)
			)
		)
		(if (and (== gPrevRoomNum 525) (not (TimeCheck $4108))) ; has 4:15 am occurred?
			((Timer new:) setReal: self 2)
		)
		(if (or (> gAct 4) (and (== gAct 4) (TimeCheck $4108 1))) ; can 4:15 am occur?
			(if (not (IsFlag 80))
				(cobraDoor init:)
				(= local5 0)
				(= local2 sCobraLoose)
			else
				(cobra init: approachVerbs: 4 1 8 stopUpd:)
			)
		else
			(mountedSkull init: approachVerbs: 4 1 8 stopUpd:)
			(cobra init: approachVerbs: 4 1 8 stopUpd:)
		)
		(if (not (IsFlag 49))
			(rosettaCloth init: approachVerbs: 4 1 8 stopUpd:)
		)
		(if
			(and
				(or
					(< gAct 4)
					(and (== gAct 4) (not (TimeCheck $3104))) ; has 3:15 am occurred?
				)
				(not (IsFlag 48))
			)
			(snakeOil init: approachVerbs: 4 1 8 stopUpd:)
		)
		(secretDoor init: stopUpd: approachVerbs: 4 ignoreActors: 1)
		(if (or (> gAct 4) (and (== gAct 4) (TimeCheck $4108 1))) ; can 4:15 am occur?
			(deadCountess init: stopUpd: approachVerbs: 1 8)
		else
			(intercom init: stopUpd: approachVerbs: 4 1 8)
		)
		(ratBack init: approachVerbs: 4 1 8)
		(ratFore init: approachVerbs: 4 1 8)
		(rosetta init: approachVerbs: 4 1 8)
		(hieroglyphics init: approachVerbs: 4 1 8)
		(certificate init:)
		(skeletonLegs init:)
		(cobraCage init:)
		(bookShelf init:)
		(jars init:)
		(chair init:)
		(skeletonFore init:)
		(desk init:)
		(windowView init:)
		(drapes init:)
		(roachTop init:)
		(roachBottom init:)
		(displayCase init:)
		(cages init:)
		(lizards init:)
		(bookcase init:)
		(lizardTable init:)
		(standRat init:)
		(if local2
			(gCurRoom setScript: local2)
		)
		(southExitFeature init:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			(
				(and
					(secretDoor cel:)
					(not (mountedSkull script:))
					(> (gEgo x:) 282)
					(> (gEgo y:) 152)
					(not (OneOf (gEgo view:) 522 528 529))
				)
				; Laura walked into the open panel (PLAY-027).
				(self setScript: sEnterPassage)
			)
			((and local4 (StepOn gEgo 16))
				(self setScript: sDropCobraGetBitten)
			)
			(
				(and
					(> (gEgo y:) 185)
					(or
						(== (gEgo view:) 522)
						(== (gEgo view:) 528)
						(== (gEgo view:) 529)
					)
				)
				(gCurRoom setScript: sDropCobraGetBitten)
			)
			((> (gEgo y:) 185)
				(= local4 1)
			)
		)
	)

	(method (cue)
		(if local10
			(super newRoom: 26)
		else
			(gGameMusic2 number: 520)
			((ScriptID 22 0) doit: 16648) ; triggerAndClock
		)
	)

	(method (newRoom param1)
		(cond
			((== param1 456)
				(super newRoom: param1)
			)
			((and (== gAct 4) (gEgo has: 31))
				(= param1 26)
				(WrapMusic dispose:)
				((ScriptID 22 0) doit: 31) ; triggerAndClock
				(gGameMusic2 number: 524 loop: 1 flags: 1 play: self)
				(= local10 1)
			)
			(else
				(gGameMusic2 fade:)
				(super newRoom: param1)
			)
		)
		((ScriptID 90 2) setPri: -1) ; aOlympia
	)
)

(instance cobra of Actor
	(properties
		name {cobra}
		x 85
		y 58
		noun 16
		approachX 78
		approachY 122
		view 521
		loop 3
		priority 2
		signal 16400
		cycleSpeed 12
	)

	(method (doVerb param1)
		(switch param1
			(1
				(gCurRoom setInset: inCobra)
			)
			(8
				(gCurRoom setInset: inCobra)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance cobraLoose of Actor
	(properties
		name {cobraLoose}
		x 77
		y 178
		view 521
		cycleSpeed 12
	)

	(method (doit)
		(if (and (not local4) (not (cobraDoor script:)) (not local5))
			(cond
				(
					(and
						local8
						(or
							(< (gEgo distanceTo: self) 40)
							(> (gEgo distanceTo: self) local9)
						)
					)
					(cobraDoor setScript: sCobraStrike)
				)
				((and (< (gEgo x:) (self x:)) local6)
					(= local6 0)
					(self setScript: sCobraTurn)
				)
				((and (> (gEgo x:) (self x:)) (not local6))
					(= local6 1)
					(self setScript: sCobraTurn)
				)
			)
		)
		(super doit:)
	)

	(method (doVerb param1)
		(switch param1
			(25
				(switch local3
					(0
						(if (< (gEgo y:) 152)
							(gEgo setMotion: MoveTo 158 130)
							(= local3 1)
						else
							(gEgo setMotion: MoveTo 160 189)
							(= local3 11)
						)
					)
					(else
						(if (gEgo has: 14)
							(++ local3)
						)
					)
				)
				(cond
					((or (> local3 13) (and (> local3 3) (< local3 9)))
						(= global150 0)
						(-- local3)
						(gMessager say: 30 0 5)
					)
					((> global150 0)
						(-- global150)
						(cobraDoor setScript: sLauraOil)
					)
					(else
						(gMessager say: 30 0 5)
					)
				)
			)
			(30
				(switch local3
					(3
						(gEgo setScript: 0)
						(= local4 1)
						(cobraDoor setScript: sLauraLasso3)
					)
					(13
						(gEgo setScript: 0)
						(= local4 1)
						(cobraDoor setScript: sLauraLasso13)
					)
					(else
						(cobraDoor setScript: sCobraStrike)
					)
				)
			)
			(4
				(cobraDoor setScript: sCobraStrike)
			)
			(1
				(gCurRoom setScript: sShowCobraLoose)
			)
			(8
				(gCurRoom setScript: sShowCobraLoose)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance cobraDoor of Prop
	(properties
		name {cobraDoor}
		x 108
		y 28
		noun 29
		view 521
		loop 8
		cel 6
		priority 2
		signal 16
	)

	(method (doVerb param1)
		(switch param1
			(4
				(self doVerb: 30)
			)
			(30
				(cond
					(local4
						(self setScript: sPutCobraBack)
					)
					((== (self cel:) 0)
						(self setCycle: End)
					)
					(else
						(self setCycle: Beg)
					)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance bigCobra of View
	(properties
		name {bigCobra}
		x 34
		y 79
		view 521
		loop 13
		cel 3
		priority 15
		signal 16
	)
)

(instance rosettaCloth of View
	(properties
		name {rosettaCloth}
		x 223
		y 105
		noun 21
		approachX 210
		approachY 131
		view 521
		loop 13
		priority 9
		signal 16400
	)

	(method (doVerb param1)
		(switch param1
			(4
				(if
					(or
						(== (gEgo view:) 522)
						(== (gEgo view:) 528)
						(== (gEgo view:) 529)
					)
					(gMessager say: 58 0 7)
				else
					(gCurRoom setScript: sRemoveCloth)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance snakeOil of View
	(properties
		name {snakeOil}
		x 113
		y 104
		z 10
		noun 30
		approachX 130
		approachY 145
		view 520
		loop 3
		priority 8
		signal 16
	)

	(method (doVerb param1)
		(switch param1
			(1
				(gCurRoom setInset: inSnakeOil)
			)
			(8
				(self doVerb: 1)
			)
			(4
				(self doVerb: 1)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance mountedSkull of Prop
	(properties
		name {mountedSkull}
		x 98
		y 74
		noun 31
		approachX 91
		approachY 141
		view 520
		loop 4
		priority 8
		signal 16
		cycleSpeed 18
	)

	(method (doVerb param1)
		(switch param1
			(4
				(cond
					(
						(or
							(== (gEgo view:) 522)
							(== (gEgo view:) 528)
							(== (gEgo view:) 529)
						)
						(gMessager say: 58 0 7)
					)
					((MuseumRgn nobodyAround:)
						; Opens the panel, or closes it if open (PLAY-027).
						(self setScript: sSecretDoor 0 (secretDoor cel:))
					)
					(else
						(return 1)
					)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance secretDoor of Prop
	(properties
		name {secretDoor}
		x 294
		y 159
		noun 59
		approachX 280 ; just outside the walk-in trigger (x > 282)
		approachY 160
		view 524
		loop 1
		cycleSpeed 12
	)

	; The fully open cel is a single blank pixel, so the doorway the panel
	; uncovers (its closed bounds) is the click area in both states.
	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (and (<= 294 temp0 317) (<= 87 temp1 176) 1))
	)

	; PLAY-027: once open, the passage can be examined, and Hand takes
	; Laura in. Closed, the panel is just part of the wall.
	(method (doVerb param1)
		(cond
			((not cel)
				(gCurRoom doVerb: param1)
			)
			((== param1 4)
				(gCurRoom setScript: sEnterPassage)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance intercom of View
	(properties
		name {intercom}
		x 179
		y 96
		noun 32
		approachX 152
		approachY 135
		view 520
		loop 3
		cel 1
		priority 8
		signal 16
	)

	(method (doVerb param1)
		(switch param1
			(1
				(gCurRoom setInset: inIntercom)
			)
			(8
				(self doVerb: 1)
			)
			(4
				(self doVerb: 1)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance deadCountess of View
	(properties
		name {deadCountess}
		x 111
		y 89
		heading 90
		noun 33
		approachX 109
		approachY 125
		view 524
		priority 8
		signal 16400
	)

	(method (doVerb param1)
		(switch param1
			(1
				(if local5
					(gEgo setHeading: 62)
					(gGame points: 1 163)
					(gCurRoom newRoom: 525)
				else
					(gMessager say: 58 0 7)
				)
			)
			(8
				(self doVerb: 1)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance ratFore of Feature
	(properties
		name {ratFore}
		x 281
		y 200
		noun 14
		onMeCheck 4
		approachX 225
		approachY 171
	)

	(method (doVerb param1)
		(switch param1
			(8
				(gCurRoom setInset: inRatFore)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance ratBack of Feature
	(properties
		name {ratBack}
		x 88
		y 21
		noun 14
		nsTop 14
		nsLeft 74
		nsBottom 29
		nsRight 103
		approachX 80
		approachY 113
	)

	(method (doVerb param1)
		(switch param1
			(8
				(gCurRoom setInset: inRatBack)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance rosetta of Feature
	(properties
		name {rosetta}
		x 293
		y 104
		heading 90
		noun 34
		sightAngle 40
		onMeCheck 256
		approachX 210
		approachY 131
	)

	(method (doVerb param1 &tmp temp0)
		(switch param1
			(8
				(if
					(or
						(== (gEgo view:) 522)
						(== (gEgo view:) 528)
						(== (gEgo view:) 529)
					)
					(gMessager say: 58 0 7)
				else
					(gGame points: 1 137)
					((ScriptID 21 0) doit: 1025) ; addCluesCode
					(for ((= temp0 14)) (< temp0 27) ((++ temp0))
						((ScriptID 21 0) doit: (+ temp0 1088)) ; addCluesCode
					)
					(gCurRoom newRoom: 456)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance certificate of Feature
	(properties
		name {certificate}
		y 1
	)

	(method (onMe param1)
		(if (super onMe: param1)
			(cond
				(
					(and
						(<= 188 gMouseX)
						(<= gMouseX 206)
						(<= 20 gMouseY)
						(<= gMouseY 43)
					)
					(= x 197)
					(= y 31)
					(= z 0)
					(= noun 2)
				)
				(
					(and
						(<= 185 gMouseX)
						(<= gMouseX 210)
						(<= 51 gMouseY)
						(<= gMouseY 72)
					)
					(= x 197)
					(= y 61)
					(= z 0)
					(= noun 3)
				)
				(
					(and
						(<= 222 gMouseX)
						(<= gMouseX 240)
						(<= 17 gMouseY)
						(<= gMouseY 37)
					)
					(= x 231)
					(= y 27)
					(= z 0)
					(= noun 4)
				)
				(
					(and
						(<= 246 gMouseX)
						(<= gMouseX 274)
						(<= 15 gMouseY)
						(<= gMouseY 38)
					)
					(= x 260)
					(= y 26)
					(= z 0)
					(= noun 5)
				)
			)
		)
	)
)

(instance skeletonLegs of Feature
	(properties
		name {skeletonLegs}
		x 302
		y 134
		noun 6
		nsLeft 285
		nsBottom 68
		nsRight 319
		sightAngle 40
	)
)

(instance cobraCage of Feature
	(properties
		name {cobraCage}
		x 93
		y 46
		noun 7
		nsTop 29
		nsLeft 78
		nsBottom 63
		nsRight 109
		sightAngle 40
		approachX 81
		approachY 116
	)

	(method (doVerb param1)
		(switch param1
			(4
				(if local4
					(cobraDoor setScript: sPutCobraBack)
				else
					(super doVerb: param1 &rest)
				)
			)
			(30
				(self doVerb: 4)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance bookShelf of Feature
	(properties
		name {bookShelf}
		x 91
		y 70
		noun 8
		nsTop 65
		nsLeft 78
		nsBottom 76
		nsRight 104
		sightAngle 40
	)
)

(instance jars of Feature
	(properties
		name {jars}
	)

	(method (onMe param1)
		(if (super onMe: param1)
			(cond
				(
					(and
						(<= 81 gMouseX)
						(<= gMouseX 88)
						(<= 79 gMouseY)
						(<= gMouseY 90)
					)
					(= x 85)
					(= y 83)
					(= z 0)
					(= noun 9)
				)
				(
					(and
						(<= 92 gMouseX)
						(<= gMouseX 101)
						(<= 79 gMouseY)
						(<= gMouseY 87)
					)
					(= x 96)
					(= y 83)
					(= z 0)
					(= noun 10)
				)
				(
					(and
						(<= 80 gMouseX)
						(<= gMouseX 90)
						(<= 90 gMouseY)
						(<= gMouseY 97)
					)
					(= x 85)
					(= y 93)
					(= z 0)
					(= noun 11)
				)
			)
		)
	)
)

(instance chair of Feature
	(properties
		name {chair}
		x 144
		y 82
		noun 12
		nsTop 76
		nsLeft 134
		nsBottom 88
		nsRight 154
		sightAngle 40
	)
)

(instance skeletonFore of Feature
	(properties
		name {skeletonFore}
		x 260
		y 164
		noun 13
		sightAngle 40
		onMeCheck 2
	)
)

(instance desk of Feature
	(properties
		name {desk}
		y 88
		noun 15
		sightAngle 40
		onMeCheck 8
	)
)

(instance windowView of Feature
	(properties
		name {windowView}
		y 47
		noun 28
		sightAngle 40
		onMeCheck 16
	)
)

(instance drapes of Feature
	(properties
		name {drapes}
		y 12
		noun 17
		sightAngle 40
		onMeCheck 32
	)
)

(instance roachTop of Feature
	(properties
		name {roachTop}
		y 55
		noun 18
		sightAngle 40
		onMeCheck 64
	)
)

(instance roachBottom of Feature
	(properties
		name {roachBottom}
		y 102
		noun 19
		sightAngle 40
		onMeCheck -32768
	)
)

(instance displayCase of Feature
	(properties
		name {displayCase}
		x 320
		y 77
		noun 20
		sightAngle 40
		onMeCheck 128
	)
)

(instance cages of Feature
	(properties
		name {cages}
		x 320
		y 128
		noun 22
		sightAngle 40
		onMeCheck 512
	)
)

(instance lizards of Feature
	(properties
		name {lizards}
		y 180
		noun 23
		sightAngle 40
		onMeCheck 1024
	)
)

(instance bookcase of Feature
	(properties
		name {bookcase}
		y 1
		noun 25
		sightAngle 40
		onMeCheck 4096
	)
)

(instance lizardTable of Feature
	(properties
		name {lizardTable}
		y 183
		noun 26
		sightAngle 40
		onMeCheck 8192
	)
)

(instance standRat of Feature
	(properties
		name {standRat}
		x 260
		y 180
		noun 27
		sightAngle 40
		onMeCheck 16384
	)
)

(instance inCobra of Inset
	(properties
		name {inCobra}
		view 521
		loop 13
		cel 1
		x 77
		y 23
		disposeNotOnMe 1
		noun 54
	)

	(method (init)
		(if
			(not
				(cond
					((> gAct 4))
					((== gAct 4)
						(TimeCheck $4108 1) ; can 4:15 am occur?
					)
				)
			)
			(fang init:)
		)
		(super init: &rest)
	)

	(method (dispose)
		(fang dispose:)
		(super dispose:)
	)

	(method (doVerb param1)
		(switch param1
			(1
				(if
					(or
						(> gAct 4)
						(and (== gAct 4) (TimeCheck $4108 1)) ; can 4:15 am occur?
					)
					(gMessager say: noun 1 8)
				else
					(gMessager say: noun 1 9)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance hieroglyphics of Feature
	(properties
		name {hieroglyphics}
		x 250
		y 65
		heading 90
		noun 24
		sightAngle 90
		onMeCheck 2048
		approachX 210
		approachY 131
	)

	(method (doVerb param1)
		(switch param1
			(1
				(if
					(or
						(== (gEgo view:) 522)
						(== (gEgo view:) 528)
						(== (gEgo view:) 529)
					)
					(gMessager say: 58 0 7)
				else
					(gGame handsOff:)
					(gCurRoom setScript: sHieroglyphics)
				)
			)
			(8
				(self doVerb: 1)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance fang of View
	(properties
		name {fang}
		x 93
		y 32
		view 521
		loop 13
		cel 2
		priority 15
		signal 16
	)
)

(instance inSnakeOil of Inset
	(properties
		name {inSnakeOil}
		view 520
		loop 2
		x 127
		y 33
		priority 15
		disposeNotOnMe 1
		noun 38
	)

	(method (dispose)
		(gCurRoom setScript: sOlympiaOil)
		(super dispose:)
	)

	(method (doVerb param1)
		(switch param1
			(4
				(self dispose:)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance inIntercom of Inset
	(properties
		name {inIntercom}
		view 520
		x 162
		y 79
		disposeNotOnMe 1
		noun 39
	)
)

(instance inRatFore of Inset
	(properties
		name {inRatFore}
		view 520
		loop 1
		x 232
		y 147
		priority 15
		disposeNotOnMe 1
		noun 40
	)
)

(instance inRatBack of Inset
	(properties
		name {inRatBack}
		view 520
		loop 1
		x 72
		y 6
		disposeNotOnMe 1
		noun 41
	)
)

(instance inHieroglyphics of Inset
	(properties
		name {inHieroglyphics}
		picture 522
		noun 24
	)

	(method (init)
		(super init: &rest)
		(proc0_8 1)
		(gWalkHandler addToFront: self)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(proc0_8 0)
		(super dispose:)
	)

	(method (doVerb param1)
		(switch param1
			(4
				(= picture (if (== picture 522) 523 else 522))
				(sFX number: 525 flags: 1 play:)
				(DrawPic picture (if (== picture 522) 11 else 12))
			)
			(13
				(self dispose:)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance sHieroglyphics of Script
	(properties
		name {sHieroglyphics}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGameMusic2 fade: 80 20 20 0)
				(= cycles 1)
			)
			(1
				(gCast eachElementDo: 102)
				(gGame handsOff:)
				(User canInput: 1)
				(gTheIconBar enable: 0 2 1)
				(gCurRoom setInset: inHieroglyphics self)
			)
			(2
				(if (not (gEgo has: 14))
					(snakeOil show:)
				)
				(gGame handsOn:)
				(gCast eachElementDo: 216)
				(= cycles 1)
			)
			(3
				(gGameMusic2 fade: 127 20 20 0)
				(self dispose:)
			)
		)
	)
)

(instance sRemoveCloth of Script
	(properties
		name {sRemoveCloth}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 215 126 self)
			)
			(1
				(rosettaCloth dispose:)
				(SetFlag 49)
				(gEgo view: 521 setLoop: 14 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo normalize: 831 setHeading: 90)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOlympiaOil of Script
	(properties
		name {sOlympiaOil}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo stopUpd:)
				(if (== ((ScriptID 90 2) room:) gCurRoomNum) ; aOlympia
					((ScriptID 90 2) ; aOlympia
						setPri: 13
						setMotion: DPath 128 183 102 160 95 125 self
					)
				else
					((ScriptID 90 2) ; aOlympia
						moveTo: gCurRoomNum
						posn: 170 250
						setPri: 13
						setMotion: DPath 128 183 102 160 95 125 self
					)
				)
			)
			(1
				(Face (ScriptID 90 2) gEgo) ; aOlympia
				(= cycles 1)
			)
			(2
				(SetFlag 48)
				((ScriptID 90 2) ; aOlympia
					view: 525
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(snakeOil dispose:)
				((ScriptID 90 2) setCycle: Beg self) ; aOlympia
			)
			(5
				((ScriptID 90 2) ; aOlympia
					view: 820
					setLoop: -1
					setCycle: Walk
					setMotion:
						MoveTo
						(+ ((ScriptID 90 2) x:) 10) ; aOlympia
						((ScriptID 90 2) y:) ; aOlympia
						self
				)
			)
			(6
				((ScriptID 90 2) setHeading: 180) ; aOlympia
				(= cycles 1)
			)
			(7
				((ScriptID 90 2) setCycle: StopWalk -1) ; aOlympia
				(= ticks 120)
			)
			(8
				(gMessager say: 1 0 1 0 self 1520)
			)
			(9
				((ScriptID 90 2) ; aOlympia
					view: 820
					setCycle: Walk
					setMotion: DPath 102 160 128 183 170 250 self
				)
			)
			(10
				((ScriptID 90 2) moveTo: -2) ; aOlympia
				(gEgo startUpd:)
				((Inv at: 14) owner: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCobraLoose of Script
	(properties
		name {sCobraLoose}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(= cycles 2)
			)
			(1
				(= ticks 180)
			)
			(2
				(sFX number: 522 flags: 1 play:)
				(= cycles 2)
			)
			(3
				(gEgo setHeading: 270)
				(= ticks 60)
			)
			(4
				(cobraLoose
					init:
					setLoop: 0
					setCycle: Fwd
					setMotion: MoveTo 86 158 self
				)
			)
			(5
				(Face gEgo cobraLoose)
				(cobraLoose setCycle: End self)
			)
			(6
				(cobraLoose
					setLoop: 9
					setCel: 0
					posn: 90 159
					setCycle: End self
				)
			)
			(7
				(cobraLoose setLoop: 11 setCel: 0 posn: 92 159 setCycle: Fwd)
				(= ticks 30)
			)
			(8
				(sFX number: 522 flags: 1 play:)
				(bigCobra init:)
				(= ticks 180)
			)
			(9
				(bigCobra dispose:)
				(= local8 1)
				(gEgo setScript: sCobraTimer)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sShowCobraLoose of Script
	(properties
		name {sShowCobraLoose}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(sFX number: 522 flags: 1 play:)
				(bigCobra
					init:
					x: (- (cobraLoose x:) 58)
					y: (- (cobraLoose y:) 80)
				)
				(= ticks 180)
			)
			(1
				(bigCobra dispose:)
				(= ticks 60)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLauraOil of Script
	(properties
		name {sLauraOil}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setScript: 0)
				(if (< local3 9)
					(gEgo setMotion: PolyPath 158 130 self)
				else
					(gEgo setMotion: PolyPath 160 179 self)
				)
			)
			(1
				(switch local3
					(1
						(= local7 0)
					)
					(2
						(= local7 0)
					)
					(3
						(= local7 1)
					)
					(11
						(= local7 2)
					)
					(12
						(= local7 2)
					)
					(13
						(= local7 3)
					)
				)
				(gEgo
					view: 522
					setLoop: local7
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(switch local3
					(1
						(cobraLoose setLoop: 0 setMotion: MoveTo 147 177 self)
					)
					(2
						(cobraLoose setLoop: 0 setMotion: MoveTo 213 171 self)
					)
					(3
						(= local9 120)
						(cobraLoose setLoop: 0 setMotion: MoveTo 260 150 self)
					)
					(11
						(cobraLoose setLoop: 0 setMotion: MoveTo 128 134 self)
					)
					(12
						(cobraLoose setLoop: 0 setMotion: MoveTo 187 133 self)
					)
					(13
						(cobraLoose setLoop: 15 setMotion: PolyPath 207 107 self)
					)
				)
			)
			(3
				(gEgo normalize: 831)
				(Face gEgo cobraLoose)
				(= cycles 1)
			)
			(4
				(cobraLoose setLoop: 4 setCel: 0 setCycle: End self)
			)
			(5
				(if (< (cobraLoose x:) (gEgo x:))
					(cobraLoose setLoop: 9 setCel: 0 setCycle: End self)
				else
					(cobraLoose setLoop: 10 setCel: 0 setCycle: End self)
				)
			)
			(6
				(if (< (cobraLoose x:) (gEgo x:))
					(cobraLoose setLoop: 11 setCel: 0 setCycle: Fwd)
				else
					(cobraLoose setLoop: 12 setCel: 0 setCycle: Fwd)
				)
				(= cycles 1)
			)
			(7
				(if (< (gEgo x:) (cobraLoose x:))
					(= local6 0)
				else
					(= local6 1)
				)
				(gEgo setScript: sCobraTimer)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLauraLasso3 of Script
	(properties
		name {sLauraLasso3}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 216 151 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo view: 522 setCycle: 0 setLoop: 5 setCel: 0)
				(= ticks 30)
			)
			(3
				(cobraLoose setLoop: 3 setCel: 0 setCycle: 0)
				(= cycles 1)
			)
			(4
				(gEgo setCycle: CT 3 1 self)
			)
			(5
				(cobraLoose hide: dispose:)
				(gEgo setCycle: End self)
			)
			(6
				(gEgo
					view: 528
					setLoop: 0
					setCel: 0
					posn: 220 152
					setLoop: -1
					setCycle: StopWalk 529
				)
				(= ticks 60)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLauraLasso13 of Script
	(properties
		name {sLauraLasso13}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(= local4 1)
				(gEgo normalize: 831 setMotion: MoveTo 209 127 self)
			)
			(1
				(gEgo
					view: 522
					setScale: Scaler 110 90 190 0
					setLoop: 6
					setCel: 0
					setCycle: StopWalk
				)
				(= cycles 1)
			)
			(2
				(cobraLoose hide: dispose:)
				(gEgo view: 522 setLoop: 6 cel: 0 setCycle: End self)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo
					view: 528
					setLoop: 3
					setCel: 6
					posn: 211 128
					setLoop: -1
					setCycle: StopWalk 529
				)
				(= ticks 60)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCobraStrike of Script
	(properties
		name {sCobraStrike}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(Face gEgo cobraLoose)
				(= local4 1)
				(cobraLoose illegalBits: 0 ignoreActors: 1)
				(if local6
					(cobraLoose
						setLoop: 0
						setCycle: Fwd
						setMotion:
							PolyPath
							(- (gEgo x:) 34)
							(+ (gEgo y:) 10)
							self
					)
				else
					(cobraLoose
						setLoop: 1
						setCycle: Fwd
						setMotion:
							PolyPath
							(+ (gEgo x:) 35)
							(+ (gEgo y:) 11)
							self
					)
				)
			)
			(1
				(gGameMusic2 stop:)
				(sFX number: 523 flags: 1 play:)
				(if local6
					(cobraLoose
						setLoop: 2
						setCel: 0
						posn: (- (gEgo x:) 21) (+ (gEgo y:) 6)
						setCycle: CT 4 1 self
					)
				else
					(cobraLoose
						setLoop: 3
						setCel: 0
						posn: (+ (gEgo x:) 21) (+ (gEgo y:) 7)
						setCycle: CT 4 1 self
					)
				)
			)
			(2
				(cobraLoose setCycle: End self)
				(sFX number: 481 flags: 5 setLoop: 1 play:)
			)
			(3
				(gEgo
					view: 523
					setLoop: 0
					setCel: 0
					posn: (+ (gEgo x:) 15) (+ (gEgo y:) 1)
					setCycle: End self
				)
			)
			(4
				(= global145 11) ; "Your dying thought is, "Venom I ever going to learn?""
				(gCurRoom newRoom: 99)
				(self dispose:)
			)
		)
	)
)

(instance sPutCobraBack of Script
	(properties
		name {sPutCobraBack}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(= local4 0)
				(gEgo setCycle: Walk setMotion: PolyPath 132 95 self)
			)
			(1
				(gEgo
					view: 522
					setLoop: 4
					setCel: 0
					posn: 126 98
					setCycle: CT 6 1 self
				)
			)
			(2
				(cobraDoor setCycle: End self)
			)
			(3
				(gGameMusic2 fade:)
				(gEgo setCycle: CT 9 1 self)
			)
			(4
				(cobra init: stopUpd:)
				(= cycles 1)
			)
			(5
				(gEgo setCycle: End)
				(cobraDoor setCycle: Beg self)
			)
			(6
				(sFX number: 441 flags: 5 setLoop: 1 play:)
				(gGame points: 1 164)
				(= local5 1)
				(SetFlag 80)
				(cobraLoose hide:)
				(gEgo
					normalize: 831
					setScale: Scaler 120 100 190 0
					signal: 16384
					setHeading: 270
				)
				(gGameMusic2 number: 520 loop: -1 flags: 1 play:)
				(= cycles 1)
			)
			(7
				(cobraDoor stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDropCobraGetBitten of Script
	(properties
		name {sDropCobraGetBitten}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(= local4 0)
				(gEgo view: 522 setLoop: 7 setCel: 0 setCycle: End self)
			)
			(1
				(= ticks 60)
			)
			(2
				(cobraLoose
					show:
					setLoop: 4
					setCel: 3
					x: (+ (gEgo x:) 4)
					y: (+ (gEgo y:) 3)
				)
				(gEgo view: 523 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(3
				(= global145 11) ; "Your dying thought is, "Venom I ever going to learn?""
				(gCurRoom newRoom: 99)
				(self dispose:)
			)
		)
	)
)

(instance sCobraTurn of Script
	(properties
		name {sCobraTurn}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(if local6
					(cobraLoose setLoop: 5 setCel: 0 setCycle: End self)
				else
					(cobraLoose setLoop: 4 setCel: 0 setCycle: End self)
				)
			)
			(1
				(if local6
					(cobraLoose setLoop: 11 setCel: 0 setCycle: End self)
				else
					(cobraLoose setLoop: 12 setCel: 0 setCycle: End self)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sCobraTimer of Script
	(properties
		name {sCobraTimer}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(= seconds 15)
			)
			(1
				(gEgo setScript: sCobraStrike)
				(self dispose:)
			)
		)
	)
)

(instance sFX of Sound
	(properties
		name {sFX}
		flags 1
	)
)

(instance southExitFeature of ExitFeature
	(properties
		name {southExitFeature}
		nsTop 184
		nsLeft 115
		nsBottom 189
		nsRight 245
		cursor 11
		exitDir 3
		noun 57
	)
)

(instance sSecretDoor of Script
	(properties
		name {sSecretDoor}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 93 122 self)
			)
			(1
				(Face gEgo mountedSkull)
				(= cycles 4)
			)
			(2
				(gEgo view: 561 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(3
				(gEgo cycleSpeed: 12 setCycle: Beg self)
				(sFX number: 49 flags: 5 setLoop: 1 play:)
				(if register
					(mountedSkull setCycle: Beg self)
				else
					(mountedSkull setCycle: End self)
				)
			)
			(4 0)
			(5
				(gEgo normalize: 831)
				(Face gEgo secretDoor)
				(sFX number: 721 flags: 5 setLoop: 1 play:)
				(if register
					(secretDoor setCycle: Beg self)
				else
					(secretDoor setCycle: End self)
				)
			)
			(6
				; The panel stays open; walking into it, or Hand on it, runs
				; sEnterPassage (PLAY-027).
				(sFX stop:)
				(secretDoor stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterPassage of Script
	(properties
		name {sEnterPassage}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				; Straight moves: a pathfinding move to this point, outside the
				; walkable area, could stall when started from the doorway's
				; edge. The open panel's one-pixel cel sits on this path and
				; would block Laura with input off, so she ignores actors and
				; control here; room 666 normalizes her again (PLAY-027).
				(gGame handsOff:)
				(gEgo illegalBits: 0 ignoreActors: 1 setMotion: MoveTo 305 167 self)
			)
			(1
				(gEgo setMotion: MoveTo 330 167 self)
			)
			(2
				(gEgo setPri: 2)
				(sFX number: 721 flags: 5 setLoop: 1 play:)
				(secretDoor setCycle: Beg self)
			)
			(3
				(sFX stop:)
				(secretDoor stopUpd:)
				(gCurRoom newRoom: (gCurRoom north:))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)
