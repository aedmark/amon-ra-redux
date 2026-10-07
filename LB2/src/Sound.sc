;;; Sierra Script 1.0 - (do not remove this comment)
(script# 989)
(include sci.sh)
(use Main)
(use Obj)


(class Sound of Obj
	(properties
		sel_20 {Sound}
		sel_41 0
		sel_90 0
		sel_99 0
		sel_40 0
		sel_94 127
		sel_60 0
		sel_3 1
		sel_14 0
		sel_165 0
		sel_89 0
		sel_91 0
		sel_92 0
		sel_93 0
		sel_42 0
		sel_166 0
	)
	
	(method (sel_109 param1)
		((super sel_109:)
			sel_166: (if argc param1 else 0)
			sel_117:
		)
	)
	
	(method (sel_110)
		(= sel_165 (= sel_14 0))
		(gSounds sel_118: self)
		(if
			(not
				(if (DoSound sndGET_AUDIO_CAPABILITY) (& sel_99 $0004))
			)
			(DoSound sndINIT self)
		)
	)
	
	(method (sel_111)
		(gSounds sel_81: self)
		(if sel_41 (DoSound sndDISPOSE self) (= sel_41 0))
		(super sel_111:)
	)
	
	(method (sel_39 theSel_42 &tmp theParamTotal)
		(= theParamTotal argc)
		(if (and argc (IsObject [theSel_42 (- argc 1)]))
			(= sel_42 [theSel_42 (= theParamTotal (- argc 1))])
		else
			(= sel_42 0)
		)
		(self sel_110:)
		(if (not sel_3) (= sel_3 1))
		(if theParamTotal
			(= sel_94 theSel_42)
		else
			(= sel_94 127)
		)
		(if
		(and (DoSound sndGET_AUDIO_CAPABILITY) (& sel_99 $0004))
			(DoAudio 2 sel_40)
		else
			(DoSound sndPLAY self 0)
		)
	)
	
	(method (sel_167)
		(cond 
			(
			(and (DoSound sndGET_AUDIO_CAPABILITY) (& sel_99 $0004)) (DoAudio 3))
			(sel_90 (DoSound sndUPDATE_CUES self) (DoSound sndSTOP self))
		)
	)
	
	(method (sel_168 param1)
		(if (not argc) (= param1 1))
		(DoSound
			sndPAUSE
			(if (self sel_115: Sound) self else 0)
			param1
		)
	)
	
	(method (sel_169 param1)
		(if (not argc) (= param1 1))
		(DoSound sndSET_HOLD self param1)
	)
	
	(method (sel_125)
		(DoSound sndSET_HOLD self 0)
	)
	
	(method (sel_170 theSel_42 param2 param3 param4 &tmp theParamTotal)
		(if
		(and (DoSound sndGET_AUDIO_CAPABILITY) (& sel_99 $0004))
			(DoAudio 3)
		else
			(= theParamTotal argc)
			(if (and argc (IsObject [theSel_42 (- argc 1)]))
				(= sel_42 [theSel_42 (= theParamTotal (- argc 1))])
			)
			(if theParamTotal
				(DoSound sndFADE self theSel_42 param2 param3 param4)
			else
				(DoSound sndFADE self 0 25 10 1)
			)
		)
	)
	
	(method (sel_171 param1)
		(if (not argc) (= param1 1))
		(DoSound sndDUMMY self param1)
	)
	
	(method (sel_172 param1)
		(DoSound sndSET_VOLUME self param1)
	)
	
	(method (sel_63 param1)
		(DoSound sndSET_PRIORITY self param1)
	)
	
	(method (sel_155 param1)
		(DoSound sndSET_LOOP self param1)
	)
	
	(method (sel_173 param1 param2 param3 param4)
		(if (and (<= 1 param1) (<= param1 15))
			(if (< param2 128)
				(DoSound sndSEND_MIDI self param1 176 param2 param3)
			else
				(DoSound sndSEND_MIDI self param1 param2 param3 param4)
			)
		)
	)
	
	(method (sel_174)
		(if
		(and (DoSound sndGET_AUDIO_CAPABILITY) (& sel_99 $0004))
			(if (and (!= sel_165 -1) (== (DoAudio 6) -1))
				(= sel_165 -1)
				(= sel_14 0)
				(if (IsObject sel_42) (sel_42 sel_145: self))
			)
		else
			(if sel_90 (DoSound sndUPDATE_CUES self))
			(if sel_14
				(= sel_165 sel_14)
				(= sel_14 0)
				(if (IsObject sel_42) (sel_42 sel_145: self))
			)
		)
	)
	
	(method (sel_175 param1)
		(if (or (not sel_166) (== sel_166 param1))
			(self sel_111:)
		)
	)
	
	(method (sel_176 theSel_42 &tmp theParamTotal)
		(= theParamTotal argc)
		(if (and argc (IsObject [theSel_42 (- argc 1)]))
			(= sel_42 [theSel_42 (= theParamTotal (- argc 1))])
		else
			(= sel_42 0)
		)
		(self sel_110:)
		(if (not sel_3) (= sel_3 1))
		(if theParamTotal
			(= sel_94 theSel_42)
		else
			(= sel_94 127)
		)
		(DoSound sndPLAY self 1)
	)
	
	(method (sel_144)
		(DoSound sndUPDATE self)
	)
)
