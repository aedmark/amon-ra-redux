;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 565)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use Inset)
(use Scaler)
(use PolyPath)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm565 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm565 of LBRoom
	(properties
		name {rm565}
		north 666
		west 550
	)

	(method (init)
		(gEgo init: normalize: 831 ignoreActors: setScale: Scaler 130 0 190 0)
		(LoadMany rsVIEW 560 561 562 563 564 565 831)
		(LoadMany rsSOUND 2 6 721)
		(LoadMany rsPIC 465 565)
		(self setRegions: 90)
		(switch gPrevRoomNum
			(north
				(gCurRoom setScript: sEnterTunnel)
			)
			(west
				(gEgo x: 8 y: 150)
			)
		)
		(super init:)
		(if (IsFlag 66)
			(gCurRoom setScript: sDeadWatney)
		else
			(gCurRoom picture: 560 drawPic: 560)
			(deskClock addToPic:)
			(deadWatney addToPic:)
			(calendar addToPic:)
			(intercom addToPic:)
			(phoneList addToPic:)
			(phone addToPic:)
			(safePic init: stopUpd:)
			(xWestDoor init:)
			(if (== gPrevRoomNum north)
				(Palette palSET_INTENSITY 0 255 100)
				(self setScript: sEnterTunnel)
			else
				(secretDoor init: stopUpd:)
				(self setScript: sEgoEnter)
			)
		)
	)

	(method (dispose)
		(DisposeScript 2565)
		(super dispose: &rest)
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
)

(instance phoneList of View
	(properties
		name {phoneList}
		x 109
		y 123
		noun 43
		view 563
		loop 4
		priority 12
		signal 16
	)
)

(instance phone of View
	(properties
		name {phone}
		x 83
		y 118
		noun 58
		view 563
		loop 4
		cel 6
		priority 12
		signal 16
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

(instance bloodDrip of Prop
	(properties
		name {bloodDrip}
		x 152
		y 125
		noun 78
		modNum 560
		view 565
	)
)

(instance feCpBlood of Feature
	(properties
		name {feCpBlood}
		y 1
		noun 61
		modNum 560
		sightAngle 40
		onMeCheck 16384
	)

	(method (doVerb param1)
		(switch param1
			(8
				(gCurRoom setInset: inFeCpBlood)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance feQuills of Feature
	(properties
		name {feQuills}
		y 1
		noun 62
		modNum 560
		sightAngle 40
		onMeCheck 8192
	)
)

(instance fePorcupine of Feature
	(properties
		name {fePorcupine}
		y 1
		noun 63
		modNum 560
		sightAngle 40
		onMeCheck 4096
	)
)

(instance feHead of Feature
	(properties
		name {feHead}
		y 1
		noun 64
		modNum 560
		sightAngle 40
		onMeCheck 2048
	)
)

(instance feHandLeft of Feature
	(properties
		name {feHandLeft}
		y 1
		noun 65
		modNum 560
		sightAngle 40
		onMeCheck 1024
	)
)

(instance feHandRight of Feature
	(properties
		name {feHandRight}
		y 1
		noun 66
		modNum 560
		sightAngle 40
		onMeCheck 512
	)
)

(instance feIntercom of Feature
	(properties
		name {feIntercom}
		y 1
		noun 67
		modNum 560
		sightAngle 40
		onMeCheck 256
	)
)

(instance feClockBroken of Feature
	(properties
		name {feClockBroken}
		y 1
		noun 53
		modNum 560
		sightAngle 40
		onMeCheck 128
	)
)

(instance feCalendar of Feature
	(properties
		name {feCalendar}
		y 1
		noun 51
		modNum 560
		sightAngle 40
		onMeCheck 64
	)
)

(instance feBody of Feature
	(properties
		name {feBody}
		y 1
		noun 70
		modNum 560
		sightAngle 40
		onMeCheck 32
	)
)

(instance feDrawerBig of Feature
	(properties
		name {feDrawerBig}
		y 1
		noun 71
		modNum 560
		sightAngle 40
		onMeCheck 16
	)
)

(instance feDrawerTop of Feature
	(properties
		name {feDrawerTop}
		y 1
		noun 72
		modNum 560
		sightAngle 40
		onMeCheck 8
	)
)

(instance feDesk of Feature
	(properties
		name {feDesk}
		y 1
		noun 73
		modNum 560
		sightAngle 40
		onMeCheck 4
	)
)

(instance sEgoEnter of Script
	(properties
		name {sEgoEnter}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 20 170 self)
			)
			(2
				(xWestDoor close:)
				(= ticks 60)
			)
			(3
				(Face gEgo deadWatney)
				(gCurRoom setScript: sDeadWatney)
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
				(gGame handsOff:)
				(secretDoor init:)
				(= cycles 2)
			)
			(1
				(= seconds 3)
			)
			(2
				(gEgo x: 306 y: 147 setPri: 5 setHeading: 180)
				(sFX number: 721 flags: 5 setLoop: 1 play:)
				(secretDoor init: setCycle: End self)
			)
			(3
				(sFX stop:)
				(gEgo setPri: -1 setMotion: MoveTo 303 177 self)
			)
			(4
				(gEgo setMotion: PolyPath 265 180 self)
				(sFX number: 721 flags: 5 setLoop: 1 play:)
				(secretDoor setCycle: Beg self)
			)
			(5 0)
			(6
				(gEgo setCycle: StopWalk -1)
				(Face gEgo deadWatney)
				(= seconds 2)
			)
			(7
				(secretDoor stopUpd:)
				(sFX stop:)
				(gCurRoom setScript: sDeadWatney)
				(self dispose:)
			)
		)
	)
)

(instance sDeadWatney of Script
	(properties
		name {sDeadWatney}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gCast eachElementDo: 102)
				(gGame setCursor: 1 1)
				(if (IsFlag 66)
					(gGameMusic2 pause: 1)
					(= local0 1)
					(fooSound number: 6 loop: -1 flags: 1 play:)
					(= cycles 1)
				else
					(SetFlag 66)
					(gCurRoom picture: 465 drawPic: 465)
					(sFX number: 84 flags: 5 loop: 1 play:)
					(wrapMusic init: -1 2 6)
					(= local1 1)
					(= ticks 180)
				)
			)
			(1
				(gAddToPics eachElementDo: 111 eachElementDo: 81 release:)
				(gGame handsOn:)
				(self setScript: sCUDeadWatney self)
			)
			(2
				(fooSound fade: 0 12 30 1)
				(if local1
					(wrapMusic dispose: 1)
				)
				(if local0
					(gGameMusic2 pause: 0)
				)
				(proc0_8 0)
				(gCurRoom newRoom: 560)
			)
		)
	)
)

(instance sCUDeadWatney of Script
	(properties
		name {sCUDeadWatney}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(= local3 gCast)
				(gCast eachElementDo: 111 eachElementDo: 81)
				(local3 eachElementDo: 102)
				(gCurRoom picture: 565)
				(DrawPic 565)
				(Animate (local3 elements:) 0)
				(gCurRoom modNum: 560)
				(= local2 gDoVerbCode)
				(= gDoVerbCode exitDoVerbCode)
				(proc0_8 1)
				(gWalkHandler addToFront: self)
				(bloodDrip init: cycleSpeed: 12 setCycle: Fwd)
				(feCpBlood init:)
				(feQuills init:)
				(fePorcupine init:)
				(feHead init:)
				(feHandLeft init:)
				(feHandRight init:)
				(feIntercom init:)
				(feClockBroken init:)
				(feCalendar init:)
				(feBody init:)
				(feDrawerBig init:)
				(feDrawerTop init:)
				(feDesk init:)
			)
			(1
				(if (gCurRoom inset:)
					((gCurRoom inset:) dispose: 0)
				)
				(gCast eachElementDo: 111)
				(= gCast local3)
				(gWalkHandler delete: self)
				(gTheIconBar enable: 7)
				(= gDoVerbCode local2)
				(self dispose:)
			)
		)
	)
)

(instance inFeCpBlood of Inset
	(properties
		name {inFeCpBlood}
		view 563
		cel 2
		x 89
		y 85
		disposeNotOnMe 1
		modNum 560
		noun 74
	)

	(method (doVerb param1)
		(switch param1
			(13
				(sCUDeadWatney cue:)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance wrapMusic of WrapMusic
	(properties
		name {wrapMusic}
	)

	(method (init)
		(= wrapSound fooSound)
		(super init: &rest)
	)
)

(instance fooSound of Sound
	(properties
		name {fooSound}
	)
)

(instance sFX of Sound
	(properties
		name {sFX}
		flags 1
	)
)

(instance exitDoVerbCode of Code
	(properties
		name {exitDoVerbCode}
	)

	(method (doit param1 param2)
		(if (== param1 13)
			(sCUDeadWatney cue:)
		else
			(proc0_6 param2 param1)
		)
	)
)

(instance xWestDoor of Door
	(properties
		name {xWestDoor}
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
		forceClose 0
		moveToX 4
		moveToY 145
	)
)
