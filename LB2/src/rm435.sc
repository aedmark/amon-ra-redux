;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 435)
(include sci.sh)
(use Main)
(use eRS)
(use Inset)
(use PolyPath)
(use Feature)
(use LoadMany)
(use Sound)
(use Actor)
(use System)

(public
	rm435 0
)

(local
	local0
)

(instance rm435 of LBRoom
	(properties
		name {rm435}
		style -32758
	)

	(method (init)
		(self picture: (if (IsFlag 72) 436 else 430))
		(LoadMany rsVIEW 431 430)
		(LoadMany rsPIC 436 780)
		(LoadMany rsSOUND 90 6 2)
		(if (== gAct 5)
			(self setRegions: 94)
		else
			(WrapMusic pause: 1)
			(self setRegions: 90)
		)
		(gEgo heading: 180)
		(super init:)
		(if (not (IsFlag 72))
			(gEgo
				init:
				normalize: (if (== gAct 5) 426 else 831)
				setScale: 125
			)
			(switch gPrevRoomNum
				(440
					(gEgo x: 51 y: 121)
				)
				(480
					(gEgo x: 114 y: 112)
				)
				(420
					(gEgo x: 319 y: 125)
				)
			)
			(gGame points: 1 143)
			(eastDoor init:)
			(eastDoor2 init:)
			(westDoor init:)
			(westDoor2 init:)
			(wireEnd init:)
			(skewer init: stopUpd:)
		)
		(gCurRoom setScript: sRunIt)
	)

	(method (dispose)
		(if local0
			(wrapMusic dispose: 1)
		)
		(screamAndLook dispose:)
		(if (< gAct 5)
			(WrapMusic pause: 0)
		)
		(super dispose:)
	)

	(method (notify)
		(if (== gAct 5)
			(self setInset: 0)
			((ScriptID 94 1) setReal: (ScriptID 94 1) 2) ; pursuitTimer, pursuitTimer
			(gCurRoom newRoom: 430)
		)
	)
)

(instance sEnter of Script
	(properties
		name {sEnter}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(if (== gPrevRoomNum 420)
					(gEgo setMotion: PolyPath 300 133 self)
				else
					(gEgo setMotion: PolyPath 100 133 self)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sRunIt of Script
	(properties
		name {sRunIt}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(if (IsFlag 72)
					(self changeState: 4)
				else
					(self setScript: sEnter self)
				)
			)
			(1
				(gEgo
					setMotion:
						PolyPath
						(gEgo x:)
						(+ (gEgo y:) 10)
						self
				)
			)
			(2
				(gEgo hide:)
				(eastDoor dispose:)
				(eastDoor2 dispose:)
				(westDoor dispose:)
				(westDoor2 dispose:)
				(wireEnd dispose:)
				(skewer dispose:)
				(gCurRoom picture: 465 drawPic: 465)
				(= cycles 1)
			)
			(3
				(wrapMusic init: -1 2 6)
				(gGameMusic2 number: 83 flags: 5 loop: 1 play:)
				(= local0 1)
				(= seconds 3)
			)
			(4
				(if (and (IsFlag 72) (!= gAct 5))
					(screamAndLook number: 6 loop: -1 flags: 1 play:)
				else
					(SetFlag 72)
					(SetFlag 143)
				)
				(client setInset: inZiggyDead self)
			)
			(5
				(gCurRoom newRoom: 430)
			)
		)
	)
)

(instance wireEnd2 of View
	(properties
		name {wireEnd2}
		x 33
		y 41
		noun 9
		view 431
		loop 4
		priority 13
		signal 16
	)

	(method (initialize))

	(method (doVerb param1)
		(switch param1
			(21
				(if (IsFlag 44)
					(super doVerb: param1 &rest)
				else
					(SetFlag 63)
					(inZiggyDead dispose:)
				)
			)
			(8
				(inZiggyDead setInset: inWire)
			)
			(13
				(inZiggyDead doVerb: param1)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance neck of Feature
	(properties
		name {neck}
		x 1
		y 1
		noun 5
		onMeCheck 16384
	)

	(method (initialize))

	(method (doVerb param1)
		(switch param1
			(13
				(inZiggyDead doVerb: param1)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance jacket of Feature
	(properties
		name {jacket}
		x 1
		y 1
		noun 3
		onMeCheck 128
	)

	(method (initialize))

	(method (doVerb param1)
		(switch param1
			(13
				(inZiggyDead doVerb: param1)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance pants of Feature
	(properties
		name {pants}
		x 1
		y 1
		noun 6
		onMeCheck 256
	)

	(method (initialize))

	(method (doVerb param1)
		(switch param1
			(13
				(inZiggyDead doVerb: param1)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance ptero of Feature
	(properties
		name {ptero}
		x 1
		y 1
		noun 2
		onMeCheck 2
	)

	(method (initialize))

	(method (doVerb param1)
		(switch param1
			(13
				(inZiggyDead doVerb: param1)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance wire1 of Feature
	(properties
		name {wire1}
		x 1
		y 1
		noun 8
		onMeCheck 4
	)

	(method (initialize))

	(method (doVerb param1)
		(switch param1
			(21
				(if (IsFlag 44)
					(super doVerb: param1 &rest)
				else
					(SetFlag 63)
					(inZiggyDead dispose:)
				)
			)
			(8
				(inZiggyDead setInset: inWire)
			)
			(13
				(inZiggyDead doVerb: param1)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance wire2 of Feature
	(properties
		name {wire2}
		x 1
		y 1
		noun 9
		onMeCheck 8
	)

	(method (initialize))

	(method (doVerb param1)
		(switch param1
			(13
				(inZiggyDead doVerb: param1)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance wire3 of Feature
	(properties
		name {wire3}
		x 1
		y 1
		noun 10
		onMeCheck 16
	)

	(method (initialize))

	(method (doVerb param1)
		(switch param1
			(13
				(inZiggyDead doVerb: param1)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance lHand of Feature
	(properties
		name {lHand}
		x 1
		y 1
		noun 4
		onMeCheck 32
	)

	(method (initialize))

	(method (doVerb param1)
		(switch param1
			(13
				(inZiggyDead doVerb: param1)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance rHand of Feature
	(properties
		name {rHand}
		x 1
		y 1
		noun 7
		onMeCheck 64
	)

	(method (initialize))

	(method (doVerb param1)
		(switch param1
			(13
				(inZiggyDead doVerb: param1)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance blood of Feature
	(properties
		name {blood}
		x 1
		y 1
		noun 1
		onMeCheck 512
	)

	(method (initialize))

	(method (doVerb param1)
		(switch param1
			(13
				(inZiggyDead doVerb: param1)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance wound of Feature
	(properties
		name {wound}
		x 1
		y 1
		noun 11
		onMeCheck 1024
	)

	(method (initialize))

	(method (doVerb param1)
		(switch param1
			(13
				(inZiggyDead doVerb: param1)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance inWire of Inset
	(properties
		name {inWire}
		view 431
		loop 2
		x 8
		y 42
		disposeNotOnMe 1
		noun 8
	)

	(method (doVerb param1)
		(switch param1
			(21
				(if (IsFlag 44)
					(super doVerb: param1 &rest)
				else
					(SetFlag 63)
					(self dispose:)
					(inZiggyDead dispose:)
				)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance inZiggyDead of Inset
	(properties
		name {inZiggyDead}
		picture 436
		style -32758
		hideTheCast 1
	)

	(method (init)
		(super init: &rest)
		(SetFlag 72)
		(SetFlag 143)
		(gCurRoom picture: 780)
		(gGame handsOn:)
		(proc0_8 1)
		(neck init:)
		(jacket init:)
		(pants init:)
		(ptero init:)
		(wire1 init:)
		(wire2 init:)
		(wire3 init:)
		(lHand init:)
		(rHand init:)
		(blood init:)
		(wound init:)
		(if (not (IsFlag 44))
			(wireEnd2 init:)
		)
		(= style 100)
	)

	(method (dispose)
		(= style -32758)
		(screamAndLook fade: 0 12 30 1)
		(proc0_8 0)
		(super dispose:)
	)

	(method (doVerb param1)
		(switch param1
			(13
				(self dispose:)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance westDoor2 of View
	(properties
		name {westDoor2}
		x 74
		y 66
		view 432
		loop 1
		cel 4
		signal 16384
	)
)

(instance eastDoor2 of View
	(properties
		name {eastDoor2}
		x 312
		y 68
		view 432
		loop 3
		cel 9
		priority 9
		signal 16400
	)
)

(instance eastDoor of View
	(properties
		name {eastDoor}
		x 292
		y 68
		view 432
		loop 2
		cel 9
		signal 16384
	)
)

(instance westDoor of View
	(properties
		name {westDoor}
		x 53
		y 66
		view 432
		cel 4
		priority 9
		signal 16400
	)
)

(instance skewer of View
	(properties
		name {skewer}
		x 3
		y 189
		z 89
		view 430
		loop 1
		priority 15
		signal 20496
	)
)

(instance wireEnd of View
	(properties
		name {wireEnd}
		x 21
		y 130
		view 431
		loop 4
		cel 1
		priority 15
		signal 16400
	)
)

(instance wrapMusic of WrapMusic
	(properties
		name {wrapMusic}
	)

	(method (init)
		(= wrapSound screamAndLook)
		(super init: &rest)
	)
)

(instance screamAndLook of Sound
	(properties
		name {screamAndLook}
	)
)
