;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 560)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use Inset)
(use Scaler)
(use PolyPath)
(use Feature)
(use LoadMany)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm560 0
	westDoor 4
)

(local
	local0
	local1
	local2
)

(instance rm560 of LBRoom
	(properties
		name {rm560}
		picture 560
		north 666
		west 550
		vanishingX 0
	)

	(method (init)
		(LoadMany rsVIEW 560 561 562 563 564 814 831)
		(LoadMany rsSOUND 560 561 558 562 564 566 565 44 45 721 567)
		(gEgo init: normalize: 831 ignoreActors: setScale: Scaler 130 0 190 0)
		(self setRegions: 90)
		(switch gPrevRoomNum
			(north
				(gCurRoom setScript: sEnterTunnel)
			)
			(west
				(gEgo edgeHit: 0 setHeading: 270)
				(if (OneOf global111 1 7)
					(++ global111)
					(westDoor locked: 1)
					(waterPrompt setReal: waterPrompt 5)
				)
				(if
					(or
						(> gAct 3)
						(and (== gAct 3) (TimeCheck $c304 1)) ; can 12:45 am occur?
					)
					(Face gEgo deadWatney)
					(gGame points: 1 171)
				)
			)
			(565
				0
				(gGame handsOn:)
			)
			(else
				(gEgo posn: 20 180)
				(gGame handsOn:)
			)
		)
		(super init:)
		(if (== gPrevRoomNum north)
			(Palette palSET_INTENSITY 0 255 100)
		)
		(gGameMusic2 number: 565 loop: -1 flags: 1 play:)
		(if (or (> gAct 3) (and (== gAct 3) (TimeCheck $c304 1))) ; can 12:45 am occur?
			(deskClock addToPic:)
			(deadWatney addToPic:)
		else
			(deskClock addToPic: setCel: 4)
			(porcupine addToPic: approachVerbs: 4 1 8)
		)
		(calendar addToPic: approachVerbs: 4 1 8)
		(intercom addToPic: approachVerbs: 4 1 8)
		(phoneList addToPic: approachVerbs: 4 1 8)
		(phone addToPic: approachVerbs: 4 1 8)
		(safePic init: stopUpd: approachVerbs: 4 1 8)
		(westDoor init:)
		(if (!= gPrevRoomNum north)
			(secretDoor init: stopUpd:)
		)
		(genericMask init:)
		(pillars init:)
		(desk init: approachVerbs: 1)
		(drawers init:)
		(deskLamp init:)
		(chair init:)
		(rug init:)
		(fireplaceOut init:)
		(fireplaceIn init: approachVerbs: 4 1 8)
		(bookcase init:)
		(genericBookshelf init:)
		(book init: approachVerbs: 4 1 8)
		(bigPainting init:)
		(genericStars init:)
		(skylightBase init:)
		(skylightSupport init:)
		(nightSky init:)
		(buildingBig init:)
		(buildingPointed init:)
		(if (and (== gPrevRoomNum 565) (== gAct 3) (not (TimeCheck $c304))) ; has 12:45 am occurred?
			((ScriptID 22 0) doit: -15612) ; triggerAndClock
			((ScriptID 90 1) wandering: 0 room: -1) ; aCountess
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				local0
				(!= (gEgo x:) 93)
				(!= (gEgo y:) 149)
				(!= ((ScriptID 32 0) room:) gCurRoomNum) ; aHeimlich
			)
			(= local0 0)
			(self setScript: sDumpSafe)
		)
	)

	(method (dispose)
		(LoadMany 0 561 562)
		(gGameMusic2 fade:)
		(super dispose: &rest)
	)
)

(instance westDoor of Door
	(properties
		name {westDoor}
		x 17
		y 148
		noun 36
		sightAngle 40
		approachX 14
		approachY 160
		view 560
		loop 1
		priority 7
		signal 16
		entranceTo 550
		listenVerb 38
		moveToX 4
		moveToY 145
		enterType 0
		exitType 0
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 38)
	)

	(method (listen)
		(switch global111
			(2
				(gMessager say: 1 38 1 0 0 1560)
				(++ global111)
				(= locked 0)
			)
			(8
				(gMessager say: 1 38 2 0 0 1560)
				(++ global111)
				(= locked 0)
			)
			(else
				(super listen: &rest)
			)
		)
	)

	(method (createPoly)
		(super createPoly: 0 142 23 136 31 147 0 153)
	)
)

(instance secretDoor of Prop
	(properties
		name {secretDoor}
		x 294
		y 147
		view 560
		loop 2
		cycleSpeed 12
	)
)

(instance safePic of View
	(properties
		name {safePic}
		x 82
		y 100
		noun 77
		approachX 93
		approachY 149
		view 564
		loop 1
		priority 6
		signal 16
	)

	(method (doVerb param1)
		(switch param1
			(4
				(Face gEgo safePic)
				((ScriptID 561 0) init:) ; safePicture
				(= local0 1)
				(self hide:)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance deadWatney of View
	(properties
		name {deadWatney}
		x 137
		y 114
		view 560
		priority 11
		signal 16400
	)

	(method (doVerb param1)
		(switch param1
			(1
				(gGame handsOff:)
				(Face gEgo deadWatney)
				(gCurRoom newRoom: 565)
			)
			(8
				(gGame handsOff:)
				(Face gEgo deadWatney)
				(gCurRoom newRoom: 565)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance porcupine of View
	(properties
		name {porcupine}
		x 131
		y 112
		noun 37
		approachX 162
		approachY 170
		view 560
		cel 1
		priority 12
		signal 16
	)
)

(instance deskClock of View
	(properties
		name {deskClock}
		x 128
		y 114
		noun 41
		approachX 89
		approachY 185
		view 563
		loop 4
		cel 5
		priority 11
		signal 16
	)

	(method (doVerb param1)
		(switch param1
			(1
				(gCurRoom setInset: inClock)
			)
			(8
				(gCurRoom setInset: inClock)
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
		x 132
		y 122
		noun 42
		approachX 93
		approachY 171
		view 563
		loop 4
		cel 3
		priority 12
		signal 16
	)

	(method (doVerb param1)
		(switch param1
			(1
				(gCurRoom setInset: (ScriptID 562 0)) ; theIntercom
			)
			(8
				(gCurRoom setInset: (ScriptID 562 0)) ; theIntercom
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance phone of View
	(properties
		name {phone}
		x 83
		y 118
		noun 58
		approachX 62
		approachY 181
		view 563
		loop 4
		cel 6
		priority 12
		signal 16
	)

	(method (doVerb param1)
		(switch param1
			(1
				(gCurRoom setInset: inPhone)
			)
			(8
				(gCurRoom setInset: inPhone)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance phoneList of View
	(properties
		name {phoneList}
		x 109
		y 123
		noun 43
		approachX 77
		approachY 178
		view 563
		loop 4
		priority 12
		signal 16
	)

	(method (doVerb param1)
		(switch param1
			(1
				(gCurRoom setInset: inPhonelist)
			)
			(8
				(gCurRoom setInset: inPhonelist)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance calendar of View
	(properties
		name {calendar}
		x 120
		y 118
		noun 44
		approachX 99
		approachY 178
		view 563
		loop 4
		cel 1
		priority 12
		signal 16
	)

	(method (doVerb param1)
		(switch param1
			(1
				(++ local2)
				(gCurRoom setInset: inCalendar)
			)
			(8
				(++ local2)
				(gCurRoom setInset: inCalendar)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance genericMask of Feature
	(properties
		name {genericMask}
		y 2
	)

	(method (onMe param1)
		(if (super onMe: param1)
			(cond
				(
					(and
						(<= 34 gMouseX)
						(<= gMouseX 50)
						(<= 63 gMouseY)
						(<= gMouseY 87)
					)
					(= noun 4)
				)
				(
					(and
						(<= 34 gMouseX)
						(<= gMouseX 50)
						(<= 94 gMouseY)
						(<= gMouseY 126)
					)
					(= noun 5)
				)
				(
					(and
						(<= 265 gMouseX)
						(<= gMouseX 282)
						(<= 71 gMouseY)
						(<= gMouseY 97)
					)
					(= noun 6)
				)
				(
					(and
						(<= 265 gMouseX)
						(<= gMouseX 281)
						(<= 101 gMouseY)
						(<= gMouseY 127)
					)
					(= noun 7)
				)
			)
		)
	)
)

(instance pillars of Feature
	(properties
		name {pillars}
		y 1
		noun 8
		onMeCheck 8
	)
)

(instance desk of Feature
	(properties
		name {desk}
		y 117
		noun 9
		onMeCheck 2048
		approachX 114
		approachY 171
	)
)

(instance drawers of Feature
	(properties
		name {drawers}
		y 1
		noun 10
		onMeCheck 8192
	)
)

(instance deskLamp of Feature
	(properties
		name {deskLamp}
		y 1
		noun 11
		onMeCheck 4096
	)
)

(instance chair of Feature
	(properties
		name {chair}
		y 1
		noun 12
		onMeCheck 16384
	)
)

(instance rug of Feature
	(properties
		name {rug}
		y 1
		noun 13
		onMeCheck 1024
	)
)

(instance fireplaceOut of Feature
	(properties
		name {fireplaceOut}
		y 1
		noun 14
		onMeCheck 512
	)
)

(instance fireplaceIn of Feature
	(properties
		name {fireplaceIn}
		y 1
		noun 15
		onMeCheck 256
		approachX 78
		approachY 145
	)

	(method (doVerb param1)
		(switch param1
			(1
				(if (or (gEgo has: 33) (IsFlag 35))
					(gMessager say: 15 1)
				else
					(gCurRoom setInset: inCharcoal)
				)
			)
			(4
				(if (or (gEgo has: 33) (IsFlag 35))
					(gMessager say: 15 4 10)
				else
					(gMessager say: 15 4 11)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance bookcase of Feature
	(properties
		name {bookcase}
		y 1
		noun 16
		onMeCheck 16
	)

	(method (doVerb param1)
		(if (and (not (gEgo has: 24)) (OneOf param1 1 4 8))
			(gCurRoom setScript: sGetBook)
		else
			(super doVerb: param1 &rest)
		)
	)
)

(instance genericBookshelf of Feature
	(properties
		name {genericBookshelf}
		y 2
		approachX 184
		approachY 169
	)

	(method (onMe param1)
		(if (super onMe: param1)
			(cond
				(
					(and
						(<= 185 gMouseX)
						(<= gMouseX 201)
						(<= 80 gMouseY)
						(<= gMouseY 92)
					)
					(= noun 17)
				)
				(
					(and
						(<= 203 gMouseX)
						(<= gMouseX 241)
						(<= 75 gMouseY)
						(<= gMouseY 89)
					)
					(= noun 18)
				)
				(
					(and
						(<= 184 gMouseX)
						(<= gMouseX 201)
						(<= 94 gMouseY)
						(<= gMouseY 107)
					)
					(= noun 19)
				)
				(
					(and
						(<= 203 gMouseX)
						(<= gMouseX 240)
						(<= 90 gMouseY)
						(<= gMouseY 106)
					)
					(= noun 20)
				)
				(
					(and
						(<= 203 gMouseX)
						(<= gMouseX 239)
						(<= 108 gMouseY)
						(<= gMouseY 120)
					)
					(= noun 21)
				)
			)
		)
	)
)

(instance book of Feature
	(properties
		name {book}
		x 221
		y 115
		heading 90
		noun 22
		nsTop 84
		nsLeft 212
		nsBottom 122
		nsRight 248
		onMeCheck 64
		approachX 214
		approachY 155
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gCurRoom setScript: sGetBook)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance bigPainting of Feature
	(properties
		name {bigPainting}
		x 154
		y 99
		noun 23
		nsTop 86
		nsLeft 135
		nsBottom 113
		nsRight 174
	)
)

(instance genericStars of Feature
	(properties
		name {genericStars}
		y 20
	)

	(method (onMe param1)
		(if
			(and
				(<= 113 gMouseX)
				(<= gMouseX 216)
				(<= 4 gMouseY)
				(<= gMouseY 41)
			)
			(if (& (OnControl CONTROL (param1 x:) (param1 y:)) $1000)
				(= noun 24)
				(return 1)
			)
			(if (& (OnControl CONTROL (param1 x:) (param1 y:)) $2000)
				(= noun 25)
				(return 1)
			)
			(if (& (OnControl CONTROL (param1 x:) (param1 y:)) $8000)
				(= noun 26)
				(return 1)
			)
			(if (& (OnControl CONTROL (param1 x:) (param1 y:)) $4000)
				(= noun 27)
				(return 1)
			)
			(if (& (OnControl CONTROL (param1 x:) (param1 y:)) $0800)
				(= noun 28)
				(return 1)
			)
			(if (& (OnControl CONTROL (param1 x:) (param1 y:)) $0400)
				(= noun 29)
				(return 1)
			)
			(if (& (OnControl CONTROL (param1 x:) (param1 y:)) $0200)
				(= noun 30)
				(return 1)
			)
		else
			0
		)
	)
)

(instance skylightBase of Feature
	(properties
		name {skylightBase}
		x 161
		y 36
		noun 31
		nsTop 1
		nsLeft 50
		nsBottom 72
		nsRight 272
		onMeCheck 16
	)
)

(instance skylightSupport of Feature
	(properties
		name {skylightSupport}
		x 161
		y 36
		noun 32
		nsTop 1
		nsLeft 50
		nsBottom 72
		nsRight 272
		onMeCheck 64
	)
)

(instance nightSky of Feature
	(properties
		name {nightSky}
		x 161
		y 36
		noun 33
		nsTop 1
		nsLeft 50
		nsBottom 72
		nsRight 272
		onMeCheck 32
	)
)

(instance buildingBig of Feature
	(properties
		name {buildingBig}
		x 161
		y 36
		noun 34
		nsTop 1
		nsLeft 50
		nsBottom 72
		nsRight 272
		onMeCheck 256
	)
)

(instance buildingPointed of Feature
	(properties
		name {buildingPointed}
		x 161
		y 36
		noun 35
		nsTop 1
		nsLeft 50
		nsBottom 72
		nsRight 272
		onMeCheck 128
	)
)

(instance inBookClosed of Inset
	(properties
		name {inBookClosed}
		view 562
		x 216
		y 69
		disposeNotOnMe 1
		noun 47
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gCurRoom setInset: inBookOpen)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance inBookOpen of Inset
	(properties
		name {inBookOpen}
		view 562
		loop 1
		x 216
		y 69
		priority 13
		disposeNotOnMe 1
		noun 48
	)

	(method (init)
		(super init: &rest)
		(if (not (gEgo has: 24))
			(file init:)
		)
	)

	(method (dispose)
		(if (IsObject file)
			(file dispose: delete:)
		)
		(super dispose:)
	)

	(method (doVerb param1)
		(switch param1
			(1
				(if (gEgo has: 24)
					(gMessager say: noun 1 9)
				else
					(gGame points: 0 183)
					((ScriptID 21 0) doit: 793) ; addCluesCode
					((ScriptID 21 0) doit: 272) ; addCluesCode
					(gMessager say: noun 1 8)
				)
			)
			(8
				(if (gEgo has: 24)
					(gMessager say: noun 8 9)
				else
					(gMessager say: noun 8 8)
				)
			)
			(4
				(if (gEgo has: 24)
					(gMessager say: noun 4 9)
				else
					(gEgo get: 24)
					(gGame points: 0 183)
					((ScriptID 21 0) doit: 793) ; addCluesCode
					((ScriptID 21 0) doit: 272) ; addCluesCode
					(gGame points: 1 172)
					(file dispose:)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance file of View
	(properties
		name {file}
		x 218
		y 71
		view 562
		loop 1
		cel 1
		priority 14
		signal 16
	)

	(method (doVerb param1)
		(inBookOpen doVerb: param1 &rest)
	)
)

(instance inCharcoal of Inset
	(properties
		name {inCharcoal}
		view 563
		cel 3
		x 21
		y 124
		disposeNotOnMe 1
		noun 45
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gCurRoom setScript: sGetCoal)
				(self dispose:)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance inClock of Inset
	(properties
		name {inClock}
		view 563
		x 101
		y 105
		disposeNotOnMe 1
		noun 52
	)

	(method (init)
		(if (IsFlag 3)
			(self cel: 1 noun: 53)
		)
		(super init: &rest)
	)
)

(instance inPhone of Inset
	(properties
		name {inPhone}
		view 563
		loop 3
		cel 3
		x 79
		y 99
		disposeNotOnMe 1
		noun 59
	)
)

(instance inPhonelist of Inset
	(properties
		name {inPhonelist}
		view 563
		loop 2
		x 87
		y 93
		disposeNotOnMe 1
		noun 49
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gCurRoom setInset: inPhoneOpen)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance inPhoneOpen of Inset
	(properties
		name {inPhoneOpen}
		view 563
		loop 2
		cel 1
		x 87
		y 93
		disposeNotOnMe 1
		noun 50
	)

	(method (doVerb param1)
		(switch param1
			(1
				(gMessager say: 50 1)
			)
			(8
				(if local2
					(gMessager say: noun param1 6)
				else
					(gMessager say: noun param1 7)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance inCalendar of Inset
	(properties
		name {inCalendar}
		view 563
		cel 4
		x 108
		y 99
		disposeNotOnMe 1
		noun 51
	)

	(method (doVerb param1)
		(switch param1
			(1
				(gGame points: 1 173)
				(gMessager say: 51 1)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance sGetCoal of Script
	(properties
		name {sGetCoal}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo normalize: 831 setMotion: PolyPath 79 143 self)
			)
			(1
				(gEgo
					view: 561
					setLoop: 1
					cel: 0
					posn: 78 141
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2
				(sFX number: 564 flags: 1 loop: 1 play:)
				(gGame points: 1 175)
				(= cycles 3)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: 831 loop: 1 posn: 79 143)
				(= cycles 1)
			)
			(5
				(gEgo get: 33)
				((ScriptID 21 0) doit: 802) ; addCluesCode
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetBook of Script
	(properties
		name {sGetBook}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo normalize: 831 setMotion: PolyPath 214 155 self)
			)
			(1
				(gEgo setHeading: 90)
				(= cycles 1)
			)
			(2
				(gEgo
					view: 561
					setLoop: 0
					cel: 0
					posn: 218 153
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(sFX number: 566 flags: 5 loop: 1 play:)
				(gEgo setCycle: Beg self)
			)
			(5
				(= ticks 60)
			)
			(6
				(gCurRoom setInset: inBookClosed)
				(gEgo normalize: 831 loop: 0 posn: 214 155)
				(= cycles 1)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDumpSafe of Script
	(properties
		name {sDumpSafe}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(if (== ((ScriptID 561 1) cel:) ((ScriptID 561 1) lastCel:)) ; safeDoor, safeDoor
					(gGame handsOff:)
					((ScriptID 561 1) setPri: 5 setCycle: Beg self) ; safeDoor
					(= local1 1)
				else
					(= cycles 1)
				)
			)
			(1
				(if local1
					(sFX number: 561 flags: 5 loop: 1 play:)
					(= local1 0)
					(= ticks 60)
				else
					(= cycles 1)
				)
			)
			(2
				(if (!= ((ScriptID 561 0) cel:) 0) ; safePicture
					((ScriptID 561 0) setCycle: Beg self) ; safePicture
					(sFX number: 45 flags: 5 loop: 1 play:)
				else
					(= cycles 1)
				)
			)
			(3
				(safePic show:)
				((ScriptID 561 0) dispose:) ; safePicture
				(= cycles 2)
			)
			(4
				(DisposeScript 561)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterTunnel of Script
	(properties
		name {sEnterTunnel}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(secretDoor init:)
				(= cycles 2)
			)
			(1
				(= seconds 3)
			)
			(2
				(gEgo x: 306 y: 147 setPri: 5 setHeading: 180)
				(sFX number: 721 flags: 5 loop: 1 play:)
				(secretDoor setCycle: End self)
			)
			(3
				(sFX stop:)
				(gEgo setPri: -1 setMotion: MoveTo 303 177 self)
			)
			(4
				(sFX number: 721 flags: 5 loop: 1 play:)
				(secretDoor setCycle: Beg self)
			)
			(5
				(secretDoor stopUpd:)
				(sFX stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance waterPrompt of Timer
	(properties
		name {waterPrompt}
	)

	(method (cue)
		(gMessager say: 79)
	)
)

(instance sFX of Sound
	(properties
		name {sFX}
		flags 1
	)
)
