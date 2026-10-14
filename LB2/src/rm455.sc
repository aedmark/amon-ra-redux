;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 455)
(include sci.sh)
(use Main)
(use eRS)
(use Inset)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm455 0
)

(instance rm455 of LBRoom
	(properties
		name {rm455}
		picture 555
	)

	(method (init)
		(LoadMany rsVIEW 470 563)
		(LoadMany rsSOUND 6)
		(super init:)
		(gGame points: 1 134)
		(self setScript: sFindPippin)
	)

	(method (dispose)
		(screamAndLook fade: 0 12 30 1)
		(super dispose:)
	)

	(method (doVerb param1)
		(switch param1
			(13
				(sFindPippin cue:)
			)
			(else
				(super doVerb: param1)
			)
		)
	)

	(method (newRoom param1)
		(proc0_8 0)
		(screamAndLook fade: 0 12 30 1)
		(wrapMusic dispose: 1)
		(super newRoom: param1)
	)
)

(instance sFindPippin of Script
	(properties
		name {sFindPippin}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGameMusic2 number: 82 flags: 5 loop: 1 play:)
				(wrapMusic init: -1 1 6)
				(= seconds 3)
			)
			(1
				(gGame handsOn:)
				(proc0_8 1)
				(gCurRoom drawPic: 470)
				(gCurRoom picture: 470)
				(drip init: setCycle: Fwd)
				(pipMummy init:)
				(leftEye init:)
				(rightEye init:)
				(nose init:)
				(moustache init:)
				(mouthOpen init:)
				(ear init:)
				(hair init:)
				(dagger init:)
				(jacket init:)
				(pants init:)
				(vest init:)
				(flesh init:)
				(shirt init:)
				(flower init:)
			)
			(2
				(gCurRoom newRoom: 454)
			)
		)
	)
)

(instance drip of Prop
	(properties
		name {drip}
		x 180
		y 100
		noun 2
		view 470
	)

	(method (doVerb param1)
		(switch param1
			(13
				(sFindPippin cue:)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance pipMummy of Feature
	(properties
		name {pipMummy}
		x 1
		y 1
		noun 13
		onMeCheck -32768
	)

	(method (doVerb param1)
		(switch param1
			(13
				(sFindPippin cue:)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance leftEye of Feature
	(properties
		name {leftEye}
		x 1
		y 1
		noun 14
		onMeCheck 2
	)

	(method (doVerb param1)
		(switch param1
			(13
				(sFindPippin cue:)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance rightEye of Feature
	(properties
		name {rightEye}
		x 1
		y 1
		noun 8
		onMeCheck 4
	)

	(method (doVerb param1)
		(switch param1
			(13
				(sFindPippin cue:)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance nose of Feature
	(properties
		name {nose}
		x 1
		y 1
		noun 11
		onMeCheck 8
	)

	(method (doVerb param1)
		(switch param1
			(13
				(sFindPippin cue:)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance moustache of Feature
	(properties
		name {moustache}
		x 1
		y 1
		noun 9
		onMeCheck 16
	)

	(method (doVerb param1)
		(switch param1
			(13
				(sFindPippin cue:)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance mouthOpen of Feature
	(properties
		name {mouthOpen}
		x 1
		y 1
		noun 10
		onMeCheck 32
	)

	(method (doVerb param1)
		(switch param1
			(13
				(sFindPippin cue:)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance ear of Feature
	(properties
		name {ear}
		x 1
		y 1
		noun 3
		onMeCheck 64
	)

	(method (doVerb param1)
		(switch param1
			(13
				(sFindPippin cue:)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance hair of Feature
	(properties
		name {hair}
		x 1
		y 1
		noun 6
		onMeCheck 128
	)

	(method (doVerb param1)
		(switch param1
			(13
				(sFindPippin cue:)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance dagger of Feature
	(properties
		name {dagger}
		x 1
		y 1
		noun 1
		onMeCheck 256
	)

	(method (doVerb param1)
		(switch param1
			(13
				(sFindPippin cue:)
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
		noun 7
		onMeCheck 512
	)

	(method (doVerb param1)
		(switch param1
			(1
				(if (gEgo has: 21)
					(gMessager say: 7 1 2)
				else
					(gMessager say: 7 1 1)
				)
			)
			(8
				(if (gEgo has: 21)
					(gMessager say: 7 8 2)
				else
					(gMessager say: 7 8 1)
				)
			)
			(4
				(if (gEgo has: 21)
					(gMessager say: 7 4 2)
				else
					(gCurRoom setInset: inNotepad)
				)
			)
			(13
				(sFindPippin cue:)
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
		noun 12
		onMeCheck 1024
	)

	(method (doVerb param1)
		(switch param1
			(13
				(sFindPippin cue:)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance vest of Feature
	(properties
		name {vest}
		x 1
		y 1
		noun 16
		onMeCheck 2048
	)

	(method (doVerb param1)
		(switch param1
			(13
				(sFindPippin cue:)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance flesh of Feature
	(properties
		name {flesh}
		x 1
		y 1
		noun 4
		onMeCheck 4096
	)

	(method (doVerb param1)
		(switch param1
			(13
				(sFindPippin cue:)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance shirt of Feature
	(properties
		name {shirt}
		x 1
		y 1
		noun 15
		onMeCheck 8192
	)

	(method (doVerb param1)
		(switch param1
			(13
				(sFindPippin cue:)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance flower of Feature
	(properties
		name {flower}
		x 1
		y 1
		noun 5
		onMeCheck 16384
	)

	(method (doVerb param1)
		(switch param1
			(13
				(sFindPippin cue:)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance inNotepad of Inset
	(properties
		name {inNotepad}
		view 563
		loop 2
		cel 2
		x 118
		y 79
		disposeNotOnMe 1
	)

	(method (init)
		(super init: &rest)
		(gMessager say: 7 4 1)
	)

	(method (doVerb param1)
		(switch param1
			(4
				(self dispose:)
				(gGame points: 1 135)
				((ScriptID 21 0) doit: 790) ; addCluesCode
				(gEgo get: 21)
			)
			(1
				(gMessager say: 45 1 0 0 0 15)
			)
			(8
				(gMessager say: 45 8 0 0 0 15)
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
		(= wrapSound screamAndLook)
		(super init: &rest)
	)
)

(instance screamAndLook of Sound
	(properties
		name {screamAndLook}
	)
)
